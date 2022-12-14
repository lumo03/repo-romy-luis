package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	private File file;
	private String fileContent;

	public FileReader(String filePath) {
		this.file = new File(filePath);
		fileContent = "";
	}

	public String readFile() {
		try {
			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				if (data != null) {
					fileContent += data + "\n";
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return fileContent;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
