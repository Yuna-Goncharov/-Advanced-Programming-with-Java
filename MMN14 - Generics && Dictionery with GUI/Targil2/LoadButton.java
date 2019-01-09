import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LoadButton extends JButton {

    public LoadButton(Controller controller) {
        setText("Load from file");
        setVisible(true);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

                int returnWin = fc.showOpenDialog(getParent());
                if (returnWin == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    controller.loadEntries(file);
                    JOptionPane.showMessageDialog(getParent(), "Values have been added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
