import javax.swing.*;
import java.io.File;

public class DictionaryController implements Controller {
	private static final int DEFAULT_HEIGHT = 600;
	private static final int DEFAULT_WIDTH = 600;

	private JFrame application;
	private Model dictionary;
	private DictionaryUI GUI;

	// creating dictionary controller
	public DictionaryController() {
		this.application = new JFrame("Dictionary");
		this.application.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		this.application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.GUI = new DictionaryUI(this);
		this.application.add(GUI);
		this.dictionary = new Dictionary();
		this.application.setVisible(true);
	}

	private void update() {
		this.GUI.setSubjects(dictionary.getAllSubjects());
		this.GUI.setDescription("");
	}

	@Override
	public boolean addNewEntry(String newVal, String description) {
		boolean isAdded = this.dictionary.add(newVal, description);
		update();
		return isAdded;
	}

	@Override
	public void deleteEntry(Entry entry) {
		this.dictionary.removeEntry(entry);
		update();
	}

	@Override
	public Entry getSelectedEntry() {
		return this.GUI.getSelectedEntry();
	}

	@Override
	public void updateEntry(Entry selected, String newDescription) {
		selected.setDescription(newDescription);
		update();
	}

	@Override
	public void loadEntries(File file) {
		this.dictionary = new Dictionary(FileHandler.readFile(file));
		update();
	}

	@Override
	public void saveToFile(File file) {
		FileHandler.saveFile(file, this.dictionary.getAllSubjects());
		update();
	}

	@Override
	public String getDescription(String searchVal) {
		return this.dictionary.getDescription(searchVal);
	}
}
