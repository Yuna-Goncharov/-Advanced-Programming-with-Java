import java.util.Objects;

public class Entry implements Comparable<Entry> {
	private String subject;
	private String description;

	// create new entry object
	public Entry(String subject, String description) {
		this.subject = subject;
		this.description = description;
	}

	public String getSubject() {
		return subject;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public int compareTo(Entry o) {
		return this.subject.compareTo(o.getSubject());
	}

	@Override
	public String toString() {
		return this.subject;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Entry))
			return false;
		Entry entry = (Entry) o;
		return Objects.equals(subject, entry.subject);
	}

	@Override
	public int hashCode() {
		return Objects.hash(subject);
	}

	public void setDescription(String newDescription) {
		this.description = newDescription;
	}

	public String toSaveFormat() {
		return getSubject() + FileHandler.DELIMITER + getDescription();
	}
}
