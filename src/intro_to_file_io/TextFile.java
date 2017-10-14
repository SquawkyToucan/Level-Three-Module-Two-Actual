package intro_to_file_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TextFile {
	public static void main(String[] args) {
		String savedText = "";
		try {
			BufferedReader read = new BufferedReader(new FileReader("listFile"));
			String line = read.readLine();
			RandomAccessFile test = new RandomAccessFile(new File("src/intro_to_file_io/test.txt"), "rw");
			String copyrightedMessage = "//not copyrighted because it's trash\n";
			test.seek(0);
			test.writeChars(copyrightedMessage + line);
			test.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}