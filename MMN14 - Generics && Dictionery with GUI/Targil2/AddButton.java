import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButton extends JButton {
	// adding buttons to controller
	public AddButton(Controller controller) {
		setText("Add");
		setVisible(true);
		// action listeners for buttons
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String description = "";
				String newVal = JOptionPane.showInputDialog(getParent(), "Please enter a value:", "New Value",
						JOptionPane.QUESTION_MESSAGE);
				if (newVal != null && !newVal.equals(""))
					description = JOptionPane.showInputDialog(getParent(), "Please enter a Description:", "New Value",
							JOptionPane.QUESTION_MESSAGE);
				if (newVal != null && !description.equals("")) {
					if (controller.addNewEntry(newVal, description)) {
						JOptionPane.showMessageDialog(getParent(), "New value has been added successfully", "Success",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(getParent(), "Value is already exist", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}
}
