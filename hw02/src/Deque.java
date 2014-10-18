import java.util.Iterator;

/**
 * Class for a generic data type for a deque.
 *
 * @param <Item> the generic data type
 */
public class Deque<Item> implements Iterable<Item> {

	/**
	 * Constructor.
	 * Constructs an empty deque.
	 */
	public Deque() {
		
	}

	/**
	 * Checks if the deque is empty.
	 * @return true if the deque is empty, false otherwise
	 */
	public boolean isEmpty() {
		return true;
	}

	/**
	 * Returns the number of items on the deque.
	 * @return the number of items on the deque
	 */
	public int size() {
		return 0;
	}

	/**
	 * Inserts the item at the front.
	 * @param item	the item to insert
	 */
	public void addFirst(Item item) {
		
	}

	/**
	 * Inserts the item at the end.
	 * @param item	the item to insert
	 */
	public void addLast(Item item) {
		
	}

	/**
	 * Delete and return the item at the front.
	 * @return the item that was removed
	 */
	public Item removeFirst() {
		return null;
	}

	/**
	 * Delete and return the item at the end.
	 * @return	the item deleted
	 */
	public Item removeLast() {
		return null;
	}

	/**
	 * Print all the Item objects in the Deque using the iterator.
	 */
	public void printAll() {
		
	}

	/**
	 * Return an iterator over items in order from front to end.
	 */
	public Iterator<Item> iterator() {
		return null;
	}

	/**
	 * Start the unit tests.
	 * @param args	the arguments
	 */
	public static void main(String[] args) {
		// unit testing
	}
}
