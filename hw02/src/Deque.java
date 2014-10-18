import java.util.Iterator;

/**
 * Class for a generic data type for a deque.
 *
 * @param <Item> the generic data type
 */
public class Deque<Item> implements Iterable<Item> {
	
	/**
	 * Pointers to the first and last nodes in the deque.
	 */
	private Node first, last;
	/**
	 * The current size of the deque.
	 */
	private int size;
	
	/**
	 * Constructor.
	 * Constructs an empty deque.
	 */
	public Deque() {
		first = null;
		last = null;
		size = 0;
	}

	/**
	 * Checks if the deque is empty.
	 * @return true if the deque is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns the number of items on the deque.
	 * @return the number of items on the deque
	 */
	public int size() {
		return size;
	}

	/**
	 * Inserts the item at the front.
	 * @param item	the item to insert
	 */
	public void addFirst(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		
		// special case for empty queue
		if (isEmpty()) {
			//last = first;		
		} else {
			
		}
		
		size++;
	}

	/**
	 * Inserts the item at the end.
	 * @param item	the item to insert
	 */
	public void addLast(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		last.prev = oldlast;
		
		// special case for empty deque
		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
		}
		
		size++;
	}

	/**
	 * Delete and return the item at the front.
	 * @return the item that was removed
	 */
	public Item removeFirst() {
		Node oldfirst = first;
		first = oldfirst.next;
		first.prev = null;
		size--;
		return oldfirst.item;
	}

	/**
	 * Delete and return the item at the end.
	 * @return	the item deleted
	 */
	public Item removeLast() {
		Node oldlast = last;
		last = oldlast.prev;
		last.next = null;
		size--;
		return oldlast.item;
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
	
	/**
	 * The linked list will be made up of nodes.
	 * Each node contains an item of generic type Item
	 * and a reference to the next Node.
	 */
	private class Node{
		Item item;
		Node next;
		Node prev;
	}
}
