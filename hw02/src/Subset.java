/**
 * A class that takes an integer k, reads in a sequence of strings, and prints
 * out exactly k of them, uniformly at random. Each item from the sequence can
 * be printed out at most once.
 */
public class Subset {
	/**
	 * Run.
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int in = Integer.parseInt(args[0]);
		RandomizedQueue<String> rq = new RandomizedQueue<String>();
		
		while (!StdIn.isEmpty()) {
			rq.enqueue(StdIn.readString());
		}
		
		for (int i = 0; i < in; i++) {
			StdOut.println(rq.dequeue());
		}

	}
}
