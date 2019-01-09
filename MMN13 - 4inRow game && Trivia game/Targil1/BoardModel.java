import java.awt.*;

/**
 * This class provides game's model and logic.
 */
public class BoardModel {
    private final static int WIN_CONDITION = 4;

    private int rows;
    private int cols;
    private Color[][] board;

    /**
     * @param rows - number of rows in new board
     * @param cols - number of columns in new board
     */
    public BoardModel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        reset();
    }

    /**
     * Check if current move is possible,
     * if so returns a row number of the playable cell
     *
     * @param coll   - column number to play (the number should be between 0 and this.cols - 1
     * @param player - color of the current player
     * @return - return a row number if current move if is valid or -1 if isn't.
     */
    public int play(int coll, Color player) {
        for (int row = this.rows - 1; row >= 0; row--) {
            if (this.board[row][coll] == null) {
                this.board[row][coll] = player;
                return row;
            }
        }
        return -1;
    }

    /**
     * Check if the game is over,
     * Search for 4 sequentially cells of current color
     *
     * @param currentPlayer - color of the current player
     * @return - true if game is over, else return false
     */
    public boolean isGameOver(Color currentPlayer) {
        if (horizontalCheck(currentPlayer)) return true;
        if (verticalCheck(currentPlayer)) return true;
        return diagonallyCheck(currentPlayer);
    }

    /**
     * Reset the playable board
     */
    public void reset() {
        this.board = new Color[this.rows][this.cols];
    }

    /**
     * Diagonally check of the winning condition
     *
     * @param currentPlayer - color of the current player
     * @return return - true if condition is met, else return false
     */
    private boolean diagonallyCheck(Color currentPlayer) {
        for (int row = this.rows - 4; row >= 0; row--) {
            int counter = 0;
            int currRow = row;
            for (int col = 0; col < this.rows && currRow < this.rows; col++) {
                Color cell = board[currRow][col];
                if (currentPlayer.equals(cell)) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == WIN_CONDITION) {
                    return true;
                }
                currRow++;
            }
        }

        for (int col = 0; col < this.cols; col++) {
            int counter = 0;
            int currentCol = col;
            for (int row = 0; row < this.rows && currentCol < this.cols; row++) {
                Color cell = board[row][currentCol];
                if (currentPlayer.equals(cell)) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == WIN_CONDITION) {
                    return true;
                }
                currentCol++;
            }
        }

        for (int col = this.cols - 1; col >= 0; col--) {
            int counter = 0;
            int currentCol = col;
            for (int row = 0; row < this.rows && currentCol >= 0; row++) {
                Color cell = board[row][currentCol];
                if (currentPlayer.equals(cell)) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == WIN_CONDITION) {
                    return true;
                }
                currentCol--;
            }
        }

        for (int row = this.rows - 1; row >= 0; row--) {
            int counter = 0;
            int currentRow = row;
            for (int col = this.cols - 1; col >= 0 && currentRow < this.rows; col--) {
                Color cell = board[currentRow][col];
                if (currentPlayer.equals(cell)) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == WIN_CONDITION) {
                    return true;
                }
                currentRow++;
            }
        }

        return false;
    }

    /**
     * Vertically check of the winning condition
     *
     * @param currentPlayer - color of the current player
     * @return return - true if condition is met, else return false
     */
    private boolean verticalCheck(Color currentPlayer) {
        for (int i = 0; i < this.cols; i++) {
            int counter = 0;
            for (int j = 0; j < this.rows; j++) {
                if (currentPlayer.equals(this.board[j][i])) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Horizontally check of the winning condition
     *
     * @param currentPlayer - color of the current player
     * @return return - true if condition is met, else return false
     */
    private boolean horizontalCheck(Color currentPlayer) {
        for (int i = 0; i < this.rows; i++) {
            int counter = 0;
            for (int j = 0; j < this.cols; j++) {
                if (currentPlayer.equals(this.board[i][j])) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == 4) {
                    return true;
                }
            }
        }
        return false;
    }
}
