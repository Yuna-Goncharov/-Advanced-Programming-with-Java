import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Visual implementation of the game
 */
public class GraphicBoardView extends JPanel {

    private final static int DEFAULT_HEIGHT = 400;
    private final static int DEFAULT_WIDTH = 350;

    private JButton[] buttons;
    private JButton resetButton;

    private Cell[][] cells;

    private int rows;
    private int cols;

    private int panelHeight;
    private int panelWidth;
    private int rowHeight;
    private int colWidth;

    /**
     * @param rows - number of rows in new board
     * @param cols - number of columns in new board
     */
    public GraphicBoardView(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        this.panelHeight = DEFAULT_HEIGHT;
        this.panelWidth = DEFAULT_WIDTH;
        this.rowHeight = panelHeight / (this.rows + 2);
        this.colWidth = panelWidth / this.cols;

        this.cells = new Cell[this.rows][this.cols];

        setLayout(null);
        createCells();
        createButtons();
        createResetButton();
        setVisible(true);
    }

    /**
     * Create graphic cells in the board
     */
    private void createCells() {
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                Cell cell = new Cell();
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                this.cells[row][col] = cell;
                add(cell);
            }
        }
    }

    /**
     * Create a reset button
     */
    private void createResetButton() {
        this.resetButton = new JButton(String.valueOf("Reset"));
        this.resetButton.setVisible(true);
        this.add(this.resetButton);
    }

    /**
     * Create buttons for each column
     */
    private void createButtons() {
        this.buttons = new JButton[this.cols];
        for (int i = 0; i < this.cols; i++) {
            JButton button = new JButton(String.valueOf(i + 1));
            button.setVisible(true);
            this.buttons[i] = button;
            this.add(button);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.panelHeight = getParent().getHeight();
        this.panelWidth = getParent().getWidth();
        this.rowHeight = panelHeight / (this.rows + 2);
        this.colWidth = panelWidth / this.cols;

        setBounds(0, 0, panelWidth, panelHeight);

        resizeCells();
        drawButtons();
        validate();
        repaint();
    }

    /**
     * Calculate and update size of the cells
     */
    private void resizeCells() {
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                int x = col * colWidth;
                int y = row * rowHeight;
                this.cells[row][col].setBounds(x, y, colWidth, rowHeight);
            }
        }
    }

    /**
     * Calculate and update size of the buttons
     */
    private void drawButtons() {
        int x, y;

        for (int col = 0; col < this.cols; col++) {
            x = col * colWidth;
            y = this.rows * rowHeight;
            this.buttons[col].setBounds(x, y, colWidth, rowHeight);
        }

        x = this.cols / 2 * colWidth;
        y = (this.rows + 1) * rowHeight;
        this.resetButton.setBounds(x, y, colWidth, rowHeight);
    }

    /**
     * Add listener to specific button
     *
     * @param buttonIndex - index of the button
     * @param listener    - listener that should be added
     */
    public void addActionListenerToButton(int buttonIndex, ActionListener listener) {
        this.buttons[buttonIndex].addActionListener(listener);
    }

    /**
     * Add listener to reset button
     *
     * @param listener - listener that should be added
     */
    public void addActionListenerToResetButton(ActionListener listener) {
        this.resetButton.addActionListener(listener);
    }

    /**
     * Set the color of the current player in the specific cell
     *
     * @param column        - column of the cell
     * @param row           - row of the cell
     * @param currentPlayer - color of the current player
     */
    public void play(int column, int row, Color currentPlayer) {
        this.cells[row][column].setColor(currentPlayer);
    }

    /**
     * Reset the cells
     */
    public void reset() {
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                this.cells[row][col].clear();
            }
        }
    }
}
