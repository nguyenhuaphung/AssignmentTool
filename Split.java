import java.io.*;
public class Split {
	public static void main(String args[]) throws Exception {
		if (args.length != 2 ) {
			System.out.println("Usage:java Split <testfile> <directory>");
			return;
		}
		String filename =  args[0];
		BufferedReader in;
		try {
			 in = new BufferedReader(new FileReader(filename));
			 BufferedWriter out = null;
			 String line = in.readLine();
			 int count = 1;
			 while (line != null) {
				 if (line.startsWith("----")) {
					 if (out != null)
						 out.close();
					 out = new BufferedWriter(new FileWriter(args[1]+"\\"+count+".txt"));
					 count++;
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
				  	 line = in.readLine();
				 	 continue;
				 }
				 out.write(line);
				 out.newLine();
				 line = in.readLine();
			 }
			 if (out != null)
				 out.close();
		} catch (Exception ex) {
			throw ex;
		}
	}
}
				
			
