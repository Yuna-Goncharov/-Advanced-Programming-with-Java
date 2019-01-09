import javax.swing.*;
import java.awt.*;

/**
 * Class that represents a board's cell
 */
public class Cell extends JPanel {
    private Color color;

    public Cell() {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.color != null) {
            g.setColor(color);
            g.fillOval(0, 0, getWidth(), getHeight());
        }

    }

    /**
     * Set color of the player
     *
     * @param color - color of the current player
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Reset the cell
     */
    public void clear() {
        this.color = null;
    }
}
