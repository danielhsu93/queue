
public class Subset {
	   public static void main(String[] args){
		   int in = Integer.parseInt(args[0]);
		   String[] output = new String[in];
		   for (int i=0; i< in; i++){
			   output[i] = StdIn.readString();
		   }
		   StdRandom.shuffle(output);
		   for (String st : output){
			   StdOut.println(st);
		   }
		   
	   }
}
