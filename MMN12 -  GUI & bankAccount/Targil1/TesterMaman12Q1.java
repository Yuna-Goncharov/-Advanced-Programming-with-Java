import javax.swing.*;

public class TesterMaman12Q1 {

    public static void main(String[] args){
        JFrame application = new JFrame("Maman 12");

        Panel board = new Panel();
        board.setLayout(null);
        application.add(board);

        application.setSize(400,500);
        application.setResizable(false);
        application.setVisible(true);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
