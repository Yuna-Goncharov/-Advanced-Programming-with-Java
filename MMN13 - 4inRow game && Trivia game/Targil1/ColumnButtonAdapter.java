import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represent main input process of the game
 */
public class ColumnButtonAdapter implements ActionListener {

    private int index;
    private GameController game;

    /**
     * Constructor of the listener
     *
     * @param i    - index of the row in a board
     * @param game -  game controller that performs an action based on the input
     */
    public ColumnButtonAdapter(int i, GameController game) {
        this.index = i;
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.game.play(index);
    }
}
