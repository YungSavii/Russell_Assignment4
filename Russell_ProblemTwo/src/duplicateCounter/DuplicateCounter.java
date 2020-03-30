package duplicateCounter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class DuplicateCounter {
	private Integer wordCounter;
	private Map<String, Integer> map;
	public void duplicateCounter() {
		this.wordCounter = 0;
		this.map = new HashMap<>();
	}
	public void count(String dataFile) {
		try {
			Scanner reading = new Scanner(new File(dataFile));
			while (reading.hasNextLine()) {
				String line = reading.nextLine().trim();
				String[] data = line.split("[\\W]+");
				for(String word : data) {
					this.wordCounter = map.get(word);
					this.wordCounter = (this.wordCounter == null)?1 : ++this.wordCounter;
					map.put(word, this.wordCounter);
				}
			}
			reading.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("File " + dataFile + " cannot be found!");
			System.exit(1);
		}
	}
	public void write(String outputFile) {
		FileWriter ff;
		PrintWriter pp;
		try {
			ff = new FileWriter(new File(outputFile));
			pp = new PrintWriter(ff);
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				pp.write(entry.getKey() + " occurs " + entry.getValue() + " times" + System.lineSeparator());
			}
			System.out.println("Map data written to file: " + outputFile);
			pp.flush();
			ff.close();
			pp.close();
		}
		catch (IOException ex) {
			System.out.println("Error in writing to " + outputFile + ": " + ex.getMessage());
			System.exit(1);
		}
	}
}
