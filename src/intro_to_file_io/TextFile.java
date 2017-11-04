//not copyrighted because it's trash

//not copyrighted because it's trash

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
		File file = new File("src/intro_to_file_io");
		file.listFiles();
		try {
			for(int i = 0; i < file.listFiles().length; i++) {
				BufferedReader read = new BufferedReader(new FileReader(file.listFiles()[i]));
				for(int j = 0; j < 1000; j++) {
					String current = read.readLine();
					if(current != null) {
						savedText = savedText + "\n" + current;
					}
					else {
						break;
					}
			}
			FileWriter test = new FileWriter(file.listFiles()[i]);
			String copyrightedMessage = "//not copyrighted because it's trash\n";
			test.write(copyrightedMessage + savedText);
			test.close();
			savedText = "";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}