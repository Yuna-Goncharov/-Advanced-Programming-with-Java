import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Handle the main logic of the game
 */
class Riddler extends JFrame {
    static final int ANSWERS_COUNT = 4;
    private static final long serialVersionUID = 1L;
    private static final int SCORE_FOR_CORRECT_ANSWER = 10;
    private static final int MAX_TIME_LEFT = 10;
    private static final int SCORE_FOR_WRONG_ANSWER = -5;
    private static final int DELAY_IN_MILLISECONDS = 1000;
    private static final String TRIVIA_PATH = "trivia.txt";
    private final List<Riddle> riddles = new ArrayList<>();
    private int score = 0;
    private int currentRiddle = 0;
    private JLabel labelQuestion;
    private JLabel labelTimeLeft;
    private final List<JButton> buttonAnswers = new ArrayList<>();
    private int timeLeftInSeconds = MAX_TIME_LEFT;
    private Timer timer;

    Riddler() {
        LoadRiddles();
        WindowSettings();
        SetupUi();
        displayCurrentRiddle();
    }


    /**
     * Setup the main window
     */
    private void WindowSettings() {
        Dimension dim = new Dimension(1024, 1024);

        setLayout(new GridLayout(6, 1));
        setSize(dim);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenDim.width / 2 - this.getSize().width / 2, screenDim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

    /**
     * Create and setup all GUI components
     */
    private void SetupUi() {
        labelTimeLeft = new JLabel("", SwingConstants.CENTER);
        add(labelTimeLeft);
        labelQuestion = new JLabel("", SwingConstants.CENTER);
        add(labelQuestion);
        for (int i = 0; i < ANSWERS_COUNT; i++) {
            JButton button = new JButton("");
            final int finalI = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    testAnswer(finalI);
                }
            });
            buttonAnswers.add(button);
            add(button);
        }

        timer = createTimer();
        timer.start();
    }

    /**
     * Creates timer and creates handler for tick
     *
     * @return - timer
     */
    private Timer createTimer() {
        return new Timer(DELAY_IN_MILLISECONDS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getTimeLeftInSeconds() == 0) {
                    score += SCORE_FOR_WRONG_ANSWER;
                    currentRiddle++;
                    displayCurrentRiddle();
                    setTimeLeftInSeconds(MAX_TIME_LEFT);
                } else {
                    setTimeLeftInSeconds(getTimeLeftInSeconds() - 1);
                }
            }
        });
    }

    /**
     * Load riddles from trivia.txt and deserialize it.
     */
    private void LoadRiddles() {
        riddles.clear();
        currentRiddle = 0;
        try {
            Scanner input = new Scanner(new File(TRIVIA_PATH));
            while (input.hasNext()) {
                riddles.add(new Riddle(input));
            }
            input.close();
            Collections.shuffle(riddles);

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Trivia file not found - fatal error", "error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Trivia is broken");
            System.exit(1);
        }
    }

    /**
     * Displays the current question and all possible answers
     */
    private void displayCurrentRiddle() {
        isGameOver();
        labelQuestion.setText(riddles.get(currentRiddle).getQuestion());
        for (int i = 0; i < ANSWERS_COUNT; i++) {
            String nextText = riddles.get(currentRiddle).getAnswers().get(i).getText();
            buttonAnswers.get(i).setText(nextText);
        }
        timeLeftInSeconds = MAX_TIME_LEFT;
    }

    /**
     * test if game-over, if so do the game-over logic
     */
    private void isGameOver() {
        if (currentRiddle == riddles.size()) {
            timer.stop();
            int result = JOptionPane.showConfirmDialog(this,
                    String.format("Your score is: %d \n. Do you want to retry?", score),
                    "score",
                    JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.CANCEL_OPTION) {
                timer.stop();
                System.exit(0);
            } else {
                LoadRiddles();
                displayCurrentRiddle();
                timer.start();
            }
        }
    }

    /**
     * test if user select the correct answer
     *
     * @param i - index of the selected answer
     */
    private void testAnswer(int i) {
        if (riddles.get(currentRiddle).getAnswers().get(i).isCorrect()) {
            score += SCORE_FOR_CORRECT_ANSWER;
        } else {
            score += SCORE_FOR_WRONG_ANSWER;
        }
        currentRiddle++;
        displayCurrentRiddle();
    }

    /**
     * Returns the time left for the current question
     *
     * @return - the time left for the current question
     */

    private int getTimeLeftInSeconds() {
        return timeLeftInSeconds;
    }

    /**
     * Setup the time for the question
     *
     * @param timeLeftInSeconds - time for the question in second
     */
    private void setTimeLeftInSeconds(int timeLeftInSeconds) {
        this.timeLeftInSeconds = timeLeftInSeconds;
        labelTimeLeft.setText(String.format("TimeLeft %d", timeLeftInSeconds));
    }
}
