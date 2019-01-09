import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Dictionary implements Model {

	private TreeSet<Entry> entries;

	// empty constractor
	public Dictionary() {
		this.entries = new TreeSet<>();
	}

	// creating new list entry
	public Dictionary(List<Entry> entries) {
		this.entries = new TreeSet<>(entries);
	}

	@Override
	public boolean add(String subject, String meaning) {
		if (this.entries.contains(new Entry(subject, meaning))) {
			return false;
		}
		this.entries.add(new Entry(subject, meaning));
		return true;
	}

	@Override
	public List<Entry> getAllSubjects() {
		return new ArrayList<>(this.entries);
	}

	@Override
	public void removeEntry(Entry entry) {
		entries.remove(entry);
	}

	@Override
	public String getDescription(String searchVal) {
		for (Entry entry : getAllSubjects()) {
			if (entry.getSubject().equals(searchVal)) {
				return entry.getDescription();
			}
		}
		return "";
	}
}
