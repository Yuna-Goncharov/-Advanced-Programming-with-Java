import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveButton extends JButton {

    public RemoveButton(Controller controller) {
        setText("Remove");
        setVisible(true);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Entry selected = controller.getSelectedEntry();

                if (selected == null) {
                    JOptionPane.showMessageDialog(getParent(), "Please select a value", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    controller.deleteEntry(selected);
                    JOptionPane.showMessageDialog(getParent(), "Value has been removed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
