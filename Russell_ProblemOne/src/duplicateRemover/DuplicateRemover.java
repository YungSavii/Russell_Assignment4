package duplicateRemover;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class DuplicateRemover {
	private Set<String> uniqueWords;
	
	public void duplicateRemover() {
		uniqueWords = new HashSet<>();
	}
	public void remove(String dataFile) {
		try {
			Scanner bye = new Scanner(new File(dataFile));
			while(bye.hasNext()) {
				uniqueWords.add(bye.next());
			}
			bye.close();
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
	
	public void write(String outputFile) {
		try {
			PrintWriter pt = new PrintWriter(new File(outputFile));
			for(String string : uniqueWords) {
				pt.println(string);
			}
			pt.flush();
			pt.close();
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}

}
