public class List<T extends Comparable<T>> {

	private Cell<T> head;
	private Cell<T> tail;

	// constructs an empty list
	public List() {
	}

	// returns the cell in the head of the list
	public Cell<T> getHead() {
		return head;
	}

	// returns the cell in the tail of the list
	public Cell<T> getTail() {
		return tail;
	}

	// adds a new cell to the end of the list
	public void add(T object) {
		if (isEmpty()) {
			head = tail = new Cell<T>(object);
		} else {
			tail.setNext(new Cell<T>(object));
			tail = tail.getNext();
		}
	}

	// remove first cell from list
	public T remove() throws EmptyListException {
		// if the list is empty throw exception
		if (isEmpty())
			throw new EmptyListException("The list is empty !!!");

		T removedItem = head.getData(); // retrieve data being removed

		// update references head and tail
		if (head == tail)
			head = tail = null;
		else
			head = head.getNext();

		return removedItem; // return removed cell data
	}

	// adds a new cell to the front of the list
	public void addFirst(T object) {
		if (isEmpty())
			head = tail = new Cell<T>(object);
		else {
			head = new Cell<T>(object, head);
		}
	}

	// returns true if list is empty false if not
	public boolean isEmpty() {
		return head == null;
	}

	// returns a string representation of the list
	public String toString() {
		// if list is empty return that it's empty
		if (isEmpty())
			return "The list is Empty.";

		// the string that will return
		StringBuilder returnString = new StringBuilder();
		// keeps current cell to iterate the list
		Cell<T> current = head;

		// while not end of list append current item
		while (current != null) {
			returnString.append(current.getData()).append("\t");
			current = current.getNext();
		}

		// return the string
		return returnString.toString();
	}

	//max method using compareto in order to return the max item in list 
	public static <E extends Comparable<E>> E max(List<E> listToCheck) {

		if (listToCheck.isEmpty())
			return null;

		Cell<E> curr = listToCheck.getHead();
		E max = curr.getData();

		while (curr != null) {
			if (max.compareTo(curr.getData()) < 0) {
				max = curr.getData();
			}
			curr = curr.getNext();
		}

		return max;
	}

}
