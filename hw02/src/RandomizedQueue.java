import java.util.Iterator;

/**
 * Class for a randomized queue in which the item that is removed is chosen
 * uniformly at random from items in the data structure.
 *
 * @param <Item> the generic item type
 *            
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
	
	/**
	 * the number of items currently in the queue
	 */
	int size;

	/**
	 * Function number 1.
	 * Constructor.
	 * 
	 */
	public RandomizedQueue() {
		size = 0;
	}

	/**
	 * Function number 2.
	 * Checks if the queue is empty.
	 * @return true if the queue is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Function number 3.
	 * Returns the number of items on the queue.
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * Function number 4.
	 * Add the item.
	 * @param item	the item to add
	 */
	public void enqueue(Item item) {
		
	}

	/**
	 * Function number 5.
	 * Delete and return a random item.
	 * @return
	 */
	public Item dequeue() {
		return null;
	}

	/**
	 * Function number 6.
	 * Return (but do not delete) a random item.
	 * @return a random item
	 */
	public Item sample() {
		return null;
	}

	/**
	 * Function number 7.
	 * Print all the Item objects in the queue using the iterator.
	 */
	public void printAll() {
		
	}

	/**
	 * Return an independent iterator over items in random order.
	 * @return an independent iterator over items in random order
	 */
	public Iterator<Item> iterator() {
		return null;
	}

	public static void main(String[] args) {
		// unit testing
	}
}