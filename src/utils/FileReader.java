package utils;

import java.io.File;

public class FileReader {
	private File file;
	
	public FileReader(File file) {
		this.file = file;
	}
	
	
	
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
}
