import java.io.File;

public interface Controller {
    boolean addNewEntry(String newVal, String description);

    void loadEntries(File file);

    Entry getSelectedEntry();

    void deleteEntry(Entry selected);

    void saveToFile(File file);

    String getDescription(String searchVal);

    void updateEntry(Entry selected, String newVal);
}
