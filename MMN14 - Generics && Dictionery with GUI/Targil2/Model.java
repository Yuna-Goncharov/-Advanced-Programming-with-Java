import java.util.List;

public interface Model {
    List<Entry> getAllSubjects();

    boolean add(String newVal, String description);

    void removeEntry(Entry entry);

    String getDescription(String searchVal);
}
