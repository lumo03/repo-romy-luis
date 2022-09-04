package trees;

import java.util.Scanner;

import utils.FileReader;

public class GuessAnimal {
	Scanner input = new Scanner(System.in);
	Question root;

	public GuessAnimal() {
		root = new Question("Ist es ein Säugetier?");
		root.yes = new Question("Löwe");
		root.no = new Question("Papagei");
	}

	public void play() {
		System.out.println("Willkommen beim Expertensystem");
		Question currentQuestion = root;
		
		FileReader fileReader = new FileReader(new File());

		while (true) {
			System.out.println(currentQuestion.content);
			Answer res = askForInput();
			System.out.println("Du hast die Antwort \"" + res.getResponseValue() + "\" ausgewählt.");
			currentQuestion = res == Answer.YES ? currentQuestion.yes : currentQuestion.no;
		}
	}

	public Answer askForInput() {
		String response = "";

		do {
			System.out.println("Gültige Antworten sind nur \"ja\" oder \"nein\"!");
			response = input.nextLine();
		} while (!response.toLowerCase().equals("ja") && !response.toLowerCase().equals("nein"));

		return response.equals("ja") ? Answer.YES : Answer.NO;
	}

	public static void main(String[] args) {
		GuessAnimal tr = new GuessAnimal();
		tr.play();
	}
}

enum Answer {
	YES("ja"), NO("nein");

	String resValue;

	Answer(String resValue) {
		this.resValue = resValue;
	}

	public String getResponseValue() {
		return resValue;
	}
}

class Question {
	String content;
	Question yes, no;

	public Question(String content) {
		this.content = content;
	}
}