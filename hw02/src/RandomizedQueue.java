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
	/**
	 * an array representation of the randomized queue
	 */
	private Item[] queue;
	/**
	 * the Random object
	 */
	private Random rand;
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
		@SuppressWarnings("unchecked")
		Item[] tempqueue = (Item[]) new Object[1];
		this.queue = tempqueue;
		rand = new Random();
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

		// resize the randomized queue if it is full
		if (queue.length == size){
			resize(size * 2);
		}
		
		queue[size] = item;
		size++;
		
	}

	/**
	 * Function number 5.
	 * Delete and return a random item.
	 * @return the random item that was deleted
	 */
	public Item dequeue() throws NoSuchElementException {
		// throw a java.util.NoSuchElementException if the client attemps to dequeue an item
		// from an empty randomized queue
		if (size == 0) {
			throw new NoSuchElementException();
		}
		
		// get a random item in the randomized queue
		int index = rand.nextInt(size);
		Item randitem = queue[index];
		
		// make sure there is no null element in the middle of the queue
		if (index == size - 1) {
			queue[index] = null;
		} else {
			// if element to remove is in middle of queue, replace its spot
			// with the last item in the queue
			queue[index] = queue[size - 1];
			queue[size - 1] = null;
		}

		// resize if queue is less than 1/4 full
		if (queue.length / 4 > size){
			resize(size / 2);
		}
		size--;

		return randitem;
	}

	/**
	 * Resize the randomized queue.
	 * @param size
	 */
	public void resize(int size){
		@SuppressWarnings("unchecked")
		Item[] newarray = (Item[])new Object[size];
		for (int i = 0; i < queue.length; i++){
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
		return new RQIter(queue, size);
	}

	/**
	 * Start accepting input.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// create scanner
		Scanner myScanner = new Scanner(System.in);  
		
		// the first line is always 1, so create a randomized queue
		RandomizedQueue<String> rq = new RandomizedQueue<String>();
		
		while (true) {
			String a = myScanner.nextLine();
			String[] splited = a.split(" ");
			int fxn = Integer.parseInt(splited[0]);
			String input = "";
			
			// only function 4 takes an input
			if (fxn == 4) {
				input = splited[1];
			}
			
			// break if function 7 is called
			if (fxn == 7) {
				break;
			}
			
			// else another function was called
			else {
				// check if the randomized queue is empty
				if (fxn == 2) {
					rq.isEmpty();
				}
				// check the size of the randomized queue
				else if (fxn == 3) {
					rq.size();
				}
				// add an item
				else if (fxn == 4) {
					rq.enqueue(input);
				}
				// delete an item
				else if (fxn == 5) {
					rq.dequeue();
				}
				
				// return (but do not delete) a random item
				else if (fxn == 6) {
					rq.sample();
				}
			}
		}
		
		rq.printAll();
		
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
		private int[] index;

		/**
		 * Constructor.
		 * 
		 * @param qIn
		 *            the randomized queue
		 */
		public RQIter(Item[] qIn, int size) {
			this.q = qIn;
			this.size = size;
			
			index = new int[size];
			for (int i = 0; i < size; i++) {
				index[i] = i;
			}
			
			// randomly shuffle the indices so the items
			// come out in random order
			StdRandom.shuffle(index);
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