
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileHandler {
	public final static String DELIMITER = ":";

	// handel new file - creating and reading from
	public static List<Entry> readFile(File file) {
		List<Entry> entries = new LinkedList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while (line != null && !line.isEmpty()) {
				String[] values = line.split(DELIMITER);
				entries.add(new Entry(values[0], values[1]));
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}

	// save new file and object ot file
	public static void saveFile(File file, List<Entry> entries) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for (Entry entry : entries) {
				bw.write(entry.toSaveFormat());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
