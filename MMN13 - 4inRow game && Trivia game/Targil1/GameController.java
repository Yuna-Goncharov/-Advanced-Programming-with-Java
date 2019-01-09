import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main controller of the game, handles a hole game process.
 * Responsible for game creation, UI setup and logic.
 */
public class GameController {
    private static final int DEFAULT_WIDTH = 350;
    private static final int DEFAULT_HEIGHT = 420;

    private int rows;
    private int cols;
    private BoardModel board;
    private JFrame application;
    private GraphicBoardView graphicBoard;
    private Color currentPlayer;

    /**
     * Constructor
     *
     * @param rows - rows of the game board
     * @param cols - columns of the game board
     */
    public GameController(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        setupGUI();
        this.board = new BoardModel(rows, cols);
        this.currentPlayer = Color.RED;
        addEventListeners();
        createResetListener();
    }

    /**
     * Handles the main logic of the game,
     * Responsible for switch the player and restart the game
     *
     * @param column - played column
     */
    public void play(int column) {
        int row = board.play(column, this.currentPlayer);
        if (row != -1) {
            this.graphicBoard.play(column, row, this.currentPlayer);
            if (this.board.isGameOver(this.currentPlayer)) {
                String message = getPlayerColor() + " win";
                JOptionPane.showMessageDialog(this.graphicBoard, message);
                resetGame();
            } else {
                changePlayer();
            }
        }
    }

    /**
     * Create a listener for reset button
     */
    private void createResetListener() {
        this.graphicBoard.addActionListenerToResetButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
    }

    /**
     * Restarts the hole game
     */
    private void resetGame() {
        this.board.reset();
        this.graphicBoard.reset();
        this.currentPlayer = Color.RED;
    }

    /**
     * Setup the GUI
     */
    private void setupGUI() {
        this.application = new JFrame("4 In Row!");
        this.application.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.graphicBoard = new GraphicBoardView(this.rows, this.cols);

        this.application.getContentPane().add(graphicBoard);
        this.application.setVisible(true);
    }

    /**
     * Adds listeners to each button
     */
    private void addEventListeners() {
        for (int col = 0; col < this.cols; col++) {
            this.graphicBoard.addActionListenerToButton(col, new ColumnButtonAdapter(col, this));
        }
    }

    /**
     * Change the current player
     */
    private void changePlayer() {
        if (this.currentPlayer == Color.RED) {
            this.currentPlayer = Color.BLACK;
        } else {
            this.currentPlayer = Color.RED;
        }
    }

    /**
     * Return the string value of the current player
     *
     * @return - the string value of the current player
     */
    private String getPlayerColor() {
        if (this.currentPlayer == Color.RED) {
            return "Red";
        } else {
            return "Black";
        }
    }
}












