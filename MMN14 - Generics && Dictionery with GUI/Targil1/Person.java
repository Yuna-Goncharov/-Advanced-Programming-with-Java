public class Person implements Comparable<Person> {

	private String name;
	private int birthYear;

	// adding new person object
	public Person(String name, int birthYear) {
		this.birthYear = birthYear;
		this.name = name;
	}

	// compare to is methos to compare by person year
	public int compareTo(Person p) {
		return Integer.compare(p.birthYear, this.birthYear);
	}

	// print out the person name and year of birth
	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", birthYear=" + birthYear + '}';
	}
}
