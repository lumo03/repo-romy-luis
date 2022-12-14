package trees;

import java.util.Optional;
import java.util.Scanner;

import io.github.cdimascio.dotenv.Dotenv;
import utils.FileReader;
import utils.FileWriter;
import utils.JSONParser;

public class GuessAnimal {
	Scanner input = new Scanner(System.in);
	JSONParser<Question> parser = new JSONParser<>(Question.class);
	Dotenv dotenv = Dotenv.load();
	Question root;

	public GuessAnimal() {
		/*
		 * root = new Question("Ist es ein Säugetier?"); root.yes = new
		 * Question("Löwe"); root.no = new Question("Papagei");
		 */
		root = loadSampleQuestions();
	}

	public void play() {
		System.out.println("Willkommen beim Expertensystem!");
		Question currentQuestion = root;
		Question prevQuestion = null;
		Question prevOfPrevQuestion = null;

		while (currentQuestion != null) {
			askQuestion(currentQuestion);
			Answer res = askForInput();
//			System.out.println("Du hast die Antwort \"" + res.getResponseValue() + "\" ausgewählt.");

			Question followingQuestion = currentQuestion.getFollowingQuestionByAnswer(res);

			if (followingQuestion != null) {
				prevOfPrevQuestion = prevQuestion;
				prevQuestion = currentQuestion;
				currentQuestion = followingQuestion;
			} else {
				if (res == Answer.YES) {
					didGuessCorrectly();
				} else {
					String animal = askForAnimal();
					String questionContent = addNewQuestion(currentQuestion);
					if (prevOfPrevQuestion != null) {
						prevOfPrevQuestion.no = new Question(questionContent);
						prevOfPrevQuestion.no.yes = new Question(animal);
						prevOfPrevQuestion.no.no = currentQuestion;
					}
					storeAsSampleQuestions();
				}
				currentQuestion = null;
			}
		}

		sayGoodbye();
		System.exit(0);
	}

	public void askQuestion(Question question) {
		if (question.yes == null && question.no == null) {
			System.out.println("Ist es ein(e) \"" + question.content + "\"?");
		} else {
			System.out.println(question.content);
		}
	}

	public Answer askForInput() {
		String response = "";
		Boolean isNotFirstAnswer = false;

		do {
			if (isNotFirstAnswer) {
				System.out.println("Gültige Antworten sind nur \"ja\" oder \"nein\"!");
			}
			response = input.nextLine();
			System.out.println();
			isNotFirstAnswer = true;
		} while (!response.toLowerCase().equals("ja") && !response.toLowerCase().equals("nein"));

		return response.equals("ja") ? Answer.YES : Answer.NO;
	}

	public String askForAnimal() {
		System.out.println("Um welches Tier handelt es sich denn?");
		return input.nextLine();
	}

	public String addNewQuestion(Question question) {
		System.out.println("Denke dir eine Frage zu deinem Tier aus.");
		System.out.println("Diese Frage muss ein neues Unterscheidungsmerkmal enthalten,");
		System.out.println("muss für dein Tier mit \"ja\" beantwortet werden können");
		System.out.println("und für das andere Tier (" + question.content + ") mit \"nein\".");
		String newQuestionContent = input.nextLine();
		System.out.println("Danke für deine Frage.");
		return newQuestionContent;
	}

	public void didGuessCorrectly() {
		System.out.println("Gut, dein Tier wurde korrekt erraten.");
//		System.exit(1);
	}

	public void sayGoodbye() {
		System.out.println("Danke, dass du mitgespielt hast. Bis zum nächsten Mal!");
	}

	public Question loadSampleQuestions() {
		FileReader fileReader = new FileReader(dotenv.get("FULL_QUESTIONS_JSON_PATH"));
		String fileContent = fileReader.readFile();
		Optional<Question> sampleTree = parser.parseToObject(fileContent);

		if (sampleTree.isPresent()) {
			return sampleTree.get();
		} else {
			return null;
		}
	}

	public void storeAsSampleQuestions() {
		Optional<String> json = parser.parseToJSON(root);

		if (json.isPresent()) {
			FileWriter fileWriter = new FileWriter(dotenv.get("FULL_QUESTIONS_JSON_PATH"), json.get());
			fileWriter.writeFile();
		}
	}

	public static void main(String[] args) {
		GuessAnimal tr = new GuessAnimal();
		tr.play();
	}
}