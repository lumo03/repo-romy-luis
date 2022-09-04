package trees;

import java.util.Scanner;

public class GuessAnimal {
    Scanner eingabe = new Scanner(System.in);
    Question root;

    public GuessAnimal() {
        root = new Frage("Ist es ein Säugetier?");
        root.yes = new Frage("Löwe");
        root.no =new Frage( "Papagei");
    }

    public void play() {
        System.out.println("Willkommen beim Expertensystem");
        Frage runner = root;

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