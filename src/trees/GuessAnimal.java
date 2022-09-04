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

        askQuestion(runner);
        

    }
    
    public void askQuestion(Question question) {
    	System.out.println(question.content +" ('ja' oder 'nein')");
    }
    
    public Question askForInput() {
    	String response = "";
    	do {
    		response = input.nextLine();
    	} while(!response.equals("ja") && !response.toLowerCase().equals("nein") )
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