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
	
	public String readFile() throws FileNotFoundException {
		Scanner myReader = new Scanner(file);
		while (myReader.hasNextLine() ) {
			String data = myReader.nextLine();
			return data;
		}
	}
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
}
