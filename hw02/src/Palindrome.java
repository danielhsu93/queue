/**
 * A class that reads in a sequence of characters from standard input,
 * and determines whether that sequence represents a Watson-Crick
 * complemented palindrome: the { A, C, T, G }-sequence equals its
 * reverse when you replace each base with its complement: A-T, C-G).
 */
public class Palindrome {
	/**
	 * Run.
	 * @param args the arguments
	 */
   public static void main(String[] args) {
	   Deque<Character> d = new Deque<Character>();
	   boolean status = true;
	   
	   // fill the deque with the chars
	   while(!StdIn.isEmpty()) {
		   d.addLast(StdIn.readChar());   
	   }
	   
	   // if there is an odd number of characters, it is not a 
	   // Watson-Crick complemented palindrome
	   if (d.size() % 2 != 0) {
		   status = false;
	   } else {
		// remove first and last and see if they are complements
		   for (int i = 0; i < d.size() / 2; i++) {
			   char first = d.removeFirst();
			   char last = d.removeLast();
			   // change status if they are not complements
			   if (!isComplement(first, last)) {
				   status = false;
				   break;
			   }
		   } 
	   }
	   
	   
	   
	   StdOut.println(status);
	   
   }
   
   /**
    * Helper function that determines whether two characters
    * are Watson-Crick complements.
    * @param n	the first char
    * @param m	the second char
    * @return true if they are Watson-Crick complements, false otherwise
    */
   public static boolean isComplement(char n, char m) {
	   if (n == 'A') {
		   if (m == 'T') {
			   return true;
		   } else {
			   return false;
		   }
	   } else if (n == 'C') {
		   if (m == 'G') {
			   return true;
		   } else {
			   return false;
		   }
		   
	   } else if (n == 'T') {
		   if ( m == 'A') {
			   return true;
		   } else {
			   return false;
		   }
	   } else if (n == 'G') {
		   if (m == 'C') {
			   return true;
		   } else {
			   return false;
		   }
	   } else {
		   return false;
	   }
   }
}
