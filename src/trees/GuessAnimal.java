package trees;

import java.util.Scanner;

public class GuessAnimal {
    Scanner eingabe = new Scanner(System.in);
    Question root;

    public GuessAnimal() {
        root = new Question("Ist es ein Säugetier?");
        root.yes = new Question("Löwe");
        root.no =new Question( "Papagei");
    }

    public void play() {
        System.out.println("Willkommen beim Expertensystem");
        Question runner = root;

        // Schleife
        System.out.println(runner.inhalt);
        String antwort = eingabe.nextLine();

    }

    public static void main(String[] args) {
        GuessAnimal tr = new GuessAnimal();
        tr.play();
    }
}

class Question {
    String inhalt;
    Question yes, no;

    public Question(String inhalt) {
        this.inhalt = inhalt;
    }
}