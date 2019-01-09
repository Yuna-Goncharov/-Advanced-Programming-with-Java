import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchButton extends JButton {

    public SearchButton(Controller controller) {
        setText("Search");
        setVisible(true);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchVal = JOptionPane.showInputDialog(getParent(), "Please enter a value:", "Search", JOptionPane.QUESTION_MESSAGE);
                if (searchVal != null && !searchVal.isEmpty()) {
                    String description = controller.getDescription(searchVal);
                    if (!description.isEmpty()) {
                        JOptionPane.showMessageDialog(getParent(), description, "Description", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(getParent(), "Value doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
}
