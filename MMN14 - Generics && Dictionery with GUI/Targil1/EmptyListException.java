
public class EmptyListException extends Exception {
	// empty constructor
	public EmptyListException() {
	}

	// constructor using a message
	public EmptyListException(String msg) {
		super(msg);
	}
}