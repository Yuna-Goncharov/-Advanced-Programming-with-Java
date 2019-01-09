import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SaveButton extends JButton {

    public SaveButton(Controller controller) {
        setText("Save to file");
        setVisible(true);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();

                int returnWin = fc.showSaveDialog(getParent());
                if (returnWin == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    controller.saveToFile(file);
                    JOptionPane.showMessageDialog(getParent(), "Dictionary has been saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
