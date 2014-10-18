import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class for a randomized queue in which the item that is removed is chosen
 * uniformly at random from items in the data structure.
 *
 * @param <Item> the generic item type
 *            
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] queue;
	private Random rand = new Random();
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
		queue = (Item[]) new Object[1];
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
	public void enqueue(Item item) throws NullPointerException {
		// throw a NullPointerException if the client attempts to add a null item
		if (item == null) {
			throw new NullPointerException();
		}
		if (queue.length==size){
			resize(size+1);
		}
		queue[size] = item;
		size++;
		
	}

	/**
	 * Function number 5.
	 * Delete and return a random item.
	 * @return
	 */
	public Item dequeue() throws NoSuchElementException {
		// throw a java.util.NoSuchElementException if the client attemps to dequeue an item
		// from an empty randomized queue
		if (size == 0) {
			throw new NoSuchElementException();
		}
		int index = rand.nextInt(size);
		Item randitem = queue[index];
		if (index == size-1){
			queue[index] = null;
		}
		else{
			queue[index] = queue[size-1];
			queue[size-1] = null;
		}
		if (queue.length>size){
			resize(size-1);
		}
		size--;

		return randitem;
	}

	public void resize(int size){
		@SuppressWarnings("unchecked")
		Item[] newarray = (Item[])new Object[size];
		for (int i=0; i< queue.length; i++){
			newarray[i] = queue[i];
		}
		queue = newarray;
	}
	/**
	 * Function number 6.
	 * Return (but do not delete) a random item.
	 * @return a random item
	 */
	public Item sample() throws NoSuchElementException {
		// throw a java.util.NoSuchElementException if the client attemps to dequeue an item
		// from an empty randomized queue
		if (size == 0) {
			throw new NoSuchElementException();
		}
		
		return queue[rand.nextInt(size)];
	}

	/**
	 * Function number 7.
	 * Print all the Item objects in the queue using the iterator.
	 */
	public void printAll() {
		Iterator<Item> iter = this.iterator();
		while (iter.hasNext()) {
			Item it = iter.next();
			System.out.print(it + " ");
		}
	}

	/**
	 * Return an independent iterator over items in random order.
	 * @return an independent iterator over items in random order
	 */
	public Iterator<Item> iterator() {
		return new RQIter(queue);
	}

	public static void main(String[] args) {
		// create scanner
		Scanner myScanner = new Scanner(System.in);  
		
		// the first line is always 1, so create a deque
		RandomizedQueue<String> d = new RandomizedQueue<String>();
		
		while (true) {
			String a = myScanner.nextLine();
			String[] splited = a.split(" ");
			int fxn = Integer.parseInt(splited[0]);
			String input = "";
			
			// only functions 4 and 5 take inputs
			if (fxn == 4) {
				input = splited[1];
			}
			
			// break if function 8 is called
			if (fxn == 7) {
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
				// insert item
				else if (fxn == 4) {
					d.enqueue(input);
				}
				// pop item
				else if (fxn == 5) {
					d.dequeue();
				}
				// delete and return item at the front
				else if (fxn == 6) {
					d.sample();
				}
			}
		}
		
		d.printAll();
		
		myScanner.close();
	}
	
	
	
	
	
	
	
	
	/**
	 * Class for an iterator over a randomized queue in random order.
	 */
	private class RQIter implements Iterator<Item> {
		/**
		 * The randomized queue
		 */
		private Item[] q;
		/**
		 * The current size of the randomized queue
		 */
		private int size;
		/**
		 * The array of indices
		 */
		private Integer[] index;

		/**
		 * Constructor.
		 * 
		 * @param qIn
		 *            the randomized queue
		 */
		public RQIter(Item[] qIn) {
			this.q = qIn;
			this.size = qIn.length;
			
			index = new Integer[size];
			for (int i = 0; i < size; i++) {
				index[i] = i;
			}
			
			Collections.shuffle(Arrays.asList(index));
		}

		/**
		 * Returns true if there is a next item, false otherwise.
		 * 
		 * @return true if there is a next item, false otherwise
		 */
		public boolean hasNext() {
			return size > 0;
		}

		/**
		 * Not supported.
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}

		/**
		 * Returns a random item that has not yet been chosen.
		 * 
		 * @return a random item that has not yet been chosen
		 */
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			
			int i = index[size - 1];
			size--;
			return q[i];


		}

	}
}