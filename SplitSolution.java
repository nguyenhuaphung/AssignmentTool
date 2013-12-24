import java.io.*;
public class SplitSolution {
	public static void main(String args[]) throws Exception {
		if (args.length != 4 ) {
			System.out.println("Usage:java SplitSolution <testfile> <test directory> <sol directory> <Comment dir>");
			return;
		}
		String filename =  args[0];
		BufferedReader in;
		try {
			 in = new BufferedReader(new FileReader(filename));
			 BufferedWriter out = null;
			 BufferedWriter out1 = null;
			 BufferedWriter out2 = null;
			 String line = in.readLine();
			 int count = 1;
			 while (line != null) {
				 if (line.startsWith("----")) {
					 if (out != null)
						 out.close();
					if (out1 != null)
						 out1.close();
					if (out2 != null)
						 out2.close();
					 out = new BufferedWriter(new FileWriter(args[1]+"\\"+count+".txt"));
					 out1 = new BufferedWriter(new FileWriter(args[2]+"\\"+count+".txt"));
					 out2 = new BufferedWriter(new FileWriter(args[3]+"\\"+count+".txt"));
					 count++;
					 line = in.readLine();
					 continue;
				 }
				 if (line.startsWith("test")){
					 line = in.readLine();
					 continue;
				 }
				 if (line.startsWith("@")){
				  	 out1.write(line.substring(1));
					 //out1.newLine();
					 line = in.readLine();
				 	 continue;
				 }
				 if (line.startsWith("//")){
					 out2.write(line);
					 out2.newLine();
				  	 line = in.readLine();
				 	 continue;
				 }
				 out.write(line);
				 out.newLine();
				 line = in.readLine();
			 }
			 if (out != null)
				 out.close();
			 if (out1 != null)
				 out1.close();
			 if (out2 != null)
				 out2.close();
				 
		} catch (Exception ex) {
			throw ex;
		}
	}
}
				
			
