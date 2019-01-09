import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class DictionaryUI extends JPanel {

	private JList<Entry> subjectsList;
	private JTextArea descriptionArea;
	private DefaultListModel<Entry> subjects;

	private AddButton addButton;
	private RemoveButton removeButton;
	private UpdateButton updateButton;
	private LoadButton loadButton;
	private SaveButton saveButton;
	private SearchButton searchButton;

	// setting controler UI window
	public DictionaryUI(Controller controller) {
		super();

		setBackground(Color.GRAY);
		setLayout(null);
		setupUI(controller);
		this.subjectsList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (subjectsList != null && getSelectedEntry() != null) {
					String description = getSelectedEntry().getDescription();
					setDescription(description);
					repaint();
				}
			}
		});
		add(this.subjectsList);
		add(this.descriptionArea);
	}

	// using UI for window
	private void setupUI(Controller controller) {
		this.subjects = new DefaultListModel<>();
		this.subjectsList = new JList<>(this.subjects);
		this.subjectsList.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		this.descriptionArea = new JTextArea();
		this.descriptionArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.descriptionArea.setLineWrap(true);
		this.descriptionArea.setAutoscrolls(true);
		this.descriptionArea.setEditable(false);

		createButtons(controller);
	}

	// create buttons on window
	private void createButtons(Controller controller) {
		this.addButton = new AddButton(controller);
		add(this.addButton);

		this.removeButton = new RemoveButton(controller);
		add(this.removeButton);

		this.updateButton = new UpdateButton(controller);
		add(this.updateButton);

		this.loadButton = new LoadButton(controller);
		add(this.loadButton);

		this.saveButton = new SaveButton(controller);
		add(this.saveButton);

		this.searchButton = new SearchButton(controller);
		add(this.searchButton);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		resizeComponent();
	}

	public Entry getSelectedEntry() {
		return this.subjectsList.getSelectedValue();
	}

	// handeling component window and size
	private void resizeComponent() {
		int width = getParent().getWidth() / 3;
		int height = getParent().getHeight() / 4;

		this.subjectsList.setBounds(0, 0, width, 3 * height);
		this.descriptionArea.setBounds(width, 0, 2 * width, 3 * height);

		int y = 3 * height;
		int buttonWidth = getParent().getWidth() / 6;
		int buttonHeight = getParent().getHeight() / 4;

		this.addButton.setBounds(0 * buttonWidth, y, buttonWidth, buttonHeight);
		this.removeButton.setBounds(1 * buttonWidth, y, buttonWidth, buttonHeight);
		this.updateButton.setBounds(2 * buttonWidth, y, buttonWidth, buttonHeight);
		this.loadButton.setBounds(3 * buttonWidth, y, buttonWidth, buttonHeight);
		this.saveButton.setBounds(4 * buttonWidth, y, buttonWidth, buttonHeight);
		this.searchButton.setBounds(5 * buttonWidth, y, buttonWidth, buttonHeight);
	}

	public void setSubjects(List<Entry> subjects) {
		this.subjects.clear();
		for (Entry subject : subjects) {
			this.subjects.addElement(subject);
		}
	}

	public void setDescription(String description) {
		this.descriptionArea.setText(description);
	}
}
