package trees;

import java.util.Scanner;

public class GuessAnimal {
    Scanner input = new Scanner(System.in);
    Question root;

    public GuessAnimal() {
        root = new Question("Ist es ein Säugetier?");
        root.yes = new Question("Löwe");
        root.no =new Question( "Papagei");
    }

    public void play() {
        System.out.println("Willkommen beim Expertensystem");
        Question runner = root;

        System.out.println(runner.content);
        String res = askForInput();
        System.out.println("Du hast die Antwort \""+ res+"\" ausgewählt.");
    }
    
    public String askForInput() {
    	String response = "";
    	
    	do {
    		System.out.println("Gültige Antworten sind nur \"ja\" oder \"nein\"!");
    		response = input.nextLine();
    	} while(
    			!response.toLowerCase().equals("ja") && 
    			!response.toLowerCase().equals("nein")
    	);
    	
    	return response;
    }

    public static void main(String[] args) {
        GuessAnimal tr = new GuessAnimal();
        tr.play();
    }
}

class Question {
    String content;
    Question yes, no;

    public Question(String content) {
        this.content = content;
    }
}