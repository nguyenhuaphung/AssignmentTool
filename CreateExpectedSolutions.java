import java.io.*;
public class CreateExpectedSolutions {
	public static void main(String args[]) throws Exception {
		if (args.length != 2 ) {
			System.out.println("Usage:java CreateExpectedSolutions <testfile> <directory>");
			return;
		}
		String filename =  args[0];
		BufferedReader in;
		try {
			 in = new BufferedReader(new FileReader(filename));
			 BufferedWriter out = null;
			 String line = in.readLine();
			 int count = 1;
			 boolean newline = false;
			 while (line != null) {
				 if (line.startsWith("----")) {
					 if (out != null)
						 out.close();
					 out = new BufferedWriter(new FileWriter(args[1]+"\\"+count+".txt"));
					 count++;
					 newline = false;
					 line = in.readLine();
					 continue;
				 }
				 if (line.startsWith("test")){
					 line = in.readLine();
					 continue;
				 }
				 if (line.startsWith("@@")){
				  	 line = in.readLine();
				 	 continue;
				 }
				 if (line.startsWith("//")){
					if (newline)
						out.newLine();
					else 
						newline = true;
				 	out.write(line.substring(2));
				 }
				 line = in.readLine();
			 }
			 if (out != null)
				 out.close();
		} catch (Exception ex) {
			throw ex;
		}
	}
}
				
			
