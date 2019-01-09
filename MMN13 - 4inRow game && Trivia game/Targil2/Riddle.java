import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Holds data of the question and 4 possible answers
 */
class Riddle {
    private String question;
    private final List<Answer> answers = new ArrayList<>();

    Riddle(Scanner input) {
        Deserialize(input);
        Collections.shuffle(answers);
    }

    /**
     * Reads the data from the scanner and convert it into a question and answers
     *
     * @param input - scanner to read from
     */
    private void Deserialize(Scanner input) {
        boolean isCorrect = true;
        question = input.nextLine();
        for (int i = 0; i < Riddler.ANSWERS_COUNT; i++) {
            answers.add(new Answer(input.nextLine(), isCorrect));
            isCorrect = false;
        }
    }

    /**
     * Returns a current question
     *
     * @return - a question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Returns answers for the current question
     *
     * @return - 4 possible answers for the question
     */
    public List<Answer> getAnswers() {
        return answers;
    }
}
