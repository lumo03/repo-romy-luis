package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	private File file;
	private String fileContent;
	
	public FileReader(File file) {
		this.file = file;
	}
	
	public void readFile() throws FileNotFoundException {
		try {
			Scanner myReader = new Scanner(file);
		while (myReader.hasNextLine() ) {
			String data = myReader.nextLine();
			fileContent += data;
		}
		myReader.close();
		}
	}
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
}
