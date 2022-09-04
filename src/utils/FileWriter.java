package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileWriter {
	private File file;
	private String fileContent;

	public FileWriter(String filePath) {
		this.file = new File(filePath);
		fileContent = "";
	}
	
	public FileWriter(String filePath, String fileContent) {
		this.file = new File(filePath);
		this.fileContent = fileContent;
	}

	public void writeFile() {
		java.io.FileWriter writer;
		try {
			writer = new java.io.FileWriter(file, false);
			writer.write(fileContent);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public String getFileContent() {
		return fileContent;
	}
	
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
}
