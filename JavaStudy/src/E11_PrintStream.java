import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class E11_PrintStream {

	/*
	 	# PrintStream
	 	
	 	- 
	 */
	
	public static void main(String[] args) {
		File f = new File("myfiles/print.txt");
		
		try (
			FileOutputStream fout = new FileOutputStream(f,false);
			PrintStream out = new PrintStream(fout);
		) {
			out.printf("%s: %d\n", 25);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
}
