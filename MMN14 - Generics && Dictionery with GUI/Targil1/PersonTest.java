
public class PersonTest {
	public static void testMaxPerson() {

		// person tester
		System.out.println("\nMax Person Test Starts");

		System.out.println("\nCreating empty Person List");
		List<Person> pq = new List<Person>();
		System.out.println("Printing the persons: \n" + pq.toString());

		System.out.println("\nCreating Person (\"Dana\", 1925)");
		Person person = new Person("Dana", 1925);
		System.out.println("Adding the person to the List...");
		pq.add(person);
		System.out.println("Printing the Person List: \n" + pq.toString());

		System.out.println("\nCreating Person (\"Lee\", 1991)");
		Person person1 = new Person("Lee", 1991);
		System.out.println("Adding the person to the List...");
		pq.add(person1);
		System.out.println("Printing the Person List: \n" + pq.toString());

		System.out.println("\nCreating Person (\"Mike\", 1990)");
		Person person3 = new Person("Mike", 1990);
		System.out.println("Adding the person to the List...");
		pq.add(person3);
		System.out.println("Printing the Person List: \n" + pq.toString());

		System.out.println("\nCreating Person (\"Yehezkel\", 1910)");
		Person person4 = new Person("Yehezkel", 1910);
		System.out.println("Adding the person to the List...");
		pq.add(person4);
		System.out.println("Printing the Person List: \n" + pq.toString());

		System.out.println("\nrunning max function, returned: " + List.max(pq));

		System.out.println("\n********Finished testing on Persons********\n");

	}

}
