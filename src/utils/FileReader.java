package utils;

import java.io.File;
import java.util.Scanner;

public class FileReader {
	private File file;
	
	public FileReader(File file) {
		this.file = file;
	}
	
	public void readFile() {
		Scanner myReader = new Scanner(file);
		while ()
	}
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
}
