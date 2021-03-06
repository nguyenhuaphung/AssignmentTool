import java.io.*;
public class JoinSolutionNoComment {
	public static void main(String args[]) throws Exception {
		if (args.length != 5 ) {
			System.out.println("Usage:java JoinSolution <testfile> <test directory> <sol directory>  <from> <to>");
			return;
		}
		int from = java.lang.Integer.parseInt(args[3]);
		int to = java.lang.Integer.parseInt(args[4]);
		String filename =  args[0];
		BufferedWriter out = null;
		BufferedReader in = null;
		BufferedReader in1 = null;
		
		try {
			 out = new BufferedWriter(new FileWriter(filename));
			 int i;
			 for (i = from; i <= to; i++) { 
				 in = new BufferedReader(new FileReader(args[1]+"\\"+ i +".txt"));
				 in1 = new BufferedReader(new FileReader(args[2]+"\\"+ i +".txt"));
				 
				 out.write("----------------------------------");
				 out.newLine();
				 out.write("test "+i);
				 out.newLine();
				 
				 String line = in1.readLine();
				 while (line != null) {
					out.write("//");
					out.write(line);
					out.newLine();
					line = in1.readLine();
				 }
				 in1.close();
				 line = in.readLine();
				 while (line != null) {
					out.write(line);
					out.newLine();
					line = in.readLine();
				 }
				 in.close();
			}
			out.close();
				 
		} catch (Exception ex) {
			throw ex;
		}
	}
}
				
			
