import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class for a generic data type for a deque.
 *
 * @param <Item>
 *            the generic data type
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
	 * Function number 1.
	 * Constructor. Constructs an empty deque.
	 */
	public Deque() {
		first = null;
		last = null;
		size = 0;
	}

	/**
	 * Function number 2.
	 * Checks if the deque is empty.
	 * 
	 * @return true if the deque is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Function number 3.
	 * Returns the number of items on the deque.
	 * 
	 * @return the number of items on the deque
	 */
	public int size() {
		return size;
	}

	/**
	 * Function number 4.
	 * Inserts the item at the front.
	 * 
	 * @param item
	 *            the item to insert
	 */
	public void addFirst(Item item) throws NullPointerException {
		// throw a NullPointerException if the client attempts to add a null
		// item
		if (item == null) {
			throw new NullPointerException();
		}

		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		first.prev = null;

		// special case for empty deque
		if (isEmpty()) {
			last = first;
		} else {
			oldFirst.prev = first;
		}

		size++;
	}

	/**
	 * Function number 5.
	 * Inserts the item at the end.
	 * 
	 * @param item
	 *            the item to insert
	 */
	public void addLast(Item item) throws NullPointerException {
		// throw a NullPointerException if the client attempts to add a null item
		if (item == null) {
			throw new NullPointerException();
		}

		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		last.prev = oldLast;

		// special case for empty deque
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}	
		
		size++;
	}

	/**
	 * Function number 6.
	 * Delete and return the item at the front.
	 * 
	 * @return the item that was removed
	 */
	public Item removeFirst() throws NoSuchElementException {
		// throw a java.util.NoSuchElementException if client attempts to remove
		// from an empty deque
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		Node oldFirst = first;
		
		// special case if this is the last item in the deque
		if (size == 1) {
			first = null;
			last = null;
		} else {
			first = oldFirst.next;
			first.prev = null;
		}
		
		size--;
		return oldFirst.item;
	}

	/**
	 * Function number 7.
	 * Delete and return the item at the end.
	 * 
	 * @return the item deleted
	 */
	public Item removeLast() throws NoSuchElementException {
		// throw a java.util.NoSuchElementException if client attempts to remove
		// from an empty deque
		if (isEmpty()) {
			throw new NoSuchElementException();
			}
		
		Node oldLast = last;
		
		// special case if this is the last item in the deque
		if (size == 1) {
			first = null;
			last = null;
		} else {
			last = oldLast.prev;
			last.next = null;
		}
		
		size--;
		return oldLast.item;
	}

	/**
	 * Function number 8.
	 * Print all the Item objects in the Deque using the iterator.
	 */
	public void printAll() {
		Iterator<Item> iter = this.iterator();
		while (iter.hasNext()) {
			Item it = iter.next();
			System.out.print(it + " ");
		}
	}

	/**
	 * Return an iterator over items in order from front to end.
	 */
	public Iterator<Item> iterator() {
		return new Dequeiter(first);
	}

	/**
	 * Start accepting inputs.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		// create scanner
		Scanner myScanner = new Scanner(System.in);  
		
		// the first line is always 1, so create a deque
		Deque<String> d = new Deque<String>();
		
		while (true) {
			String a = myScanner.nextLine();
			String[] splited = a.split(" ");
			int fxn = Integer.parseInt(splited[0]);
			String input = "";
			
			// only functions 4 and 5 take inputs
			if (fxn == 4 || fxn == 5) {
				input = splited[1];
			}
			
			// break if function 8 is called
			if (fxn == 8) {
				break;
			}
			
			// else another function was called
			else {
				// check if the deque is empty
				if (fxn == 2) {
					d.isEmpty();
				}
				// check the size of the deque
				else if (fxn == 3) {
					d.size();
				}
				// insert item at the front
				else if (fxn == 4) {
					d.addFirst(input);
				}
				// insert item at the end
				else if (fxn == 5) {
					d.addLast(input);
				}
				// delete and return item at the front
				else if (fxn == 6) {
					d.removeFirst();
				}
				// delete and return item at the end
				else if (fxn == 7) {
					d.removeLast();
				}
			}
		}
		
		d.printAll();
		
		myScanner.close();
	}

	/**
	 * The linked list will be made up of nodes. Each node contains an item of
	 * generic type Item and a reference to the next Node.
	 */
	private class Node {
		/**
		 * the item
		 */
		Item item;
		/**
		 * the next node
		 */
		Node next;
		/**
		 * the previous node
		 */
		Node prev;
	}

	/**
	 * Class for an iterator over a deque from front to end.
	 */
	private class Dequeiter implements Iterator<Item> {
		/**
		 * A reference to the front of the deque
		 */
		private Node head;

		/**
		 * Constructor.
		 * 
		 * @param nodeIn
		 *            the head
		 */
		public Dequeiter(Node nodeIn) {
			this.head = nodeIn;
		}

		/**
		 * Returns true if there is a next node, false otherwise.
		 * 
		 * @return true if there is a next node, false otherwise
		 */
		public boolean hasNext() {
			return head != null;
		}

		/**
		 * Not supported.
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}

		/**
		 * Returns the item in the next node.
		 * 
		 * @return the item in the next node
		 */
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			Item it = head.item;
			head = head.next;
			return it;
		}

	}
}
