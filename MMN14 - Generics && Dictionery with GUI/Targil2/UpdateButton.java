import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateButton extends JButton {

    public UpdateButton(Controller controller) {
        setText("Update");
        setVisible(true);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Entry selected = controller.getSelectedEntry();

                if (selected == null) {
                    JOptionPane.showMessageDialog(getParent(), "Please select a value", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    String subject = selected.getSubject();
                    String newVal = JOptionPane.showInputDialog(getParent(), "Please enter a description for " + subject, "New Description", JOptionPane.QUESTION_MESSAGE);

                    controller.updateEntry(selected, newVal);
                    JOptionPane.showMessageDialog(getParent(), "Value has been updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
