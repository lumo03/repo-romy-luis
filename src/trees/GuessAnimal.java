package trees;

import java.util.Scanner;

public class GuessAnimal {
    Scanner eingabe = new Scanner(System.in);
    Frage wurzel;

    public GuessAnimal() {
        wurzel = new Frage("Ist es ein Säugetier?");
        wurzel.ja = new Frage("Löwe");
        wurzel.nein =new Frage( "Papagei");
    }

    public void play() {
        System.out.println("Willkommen beim Expertensystem");
        Frage runner = wurzel;

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
    Frage ja, nein;

    public Question(String inhalt) {
        this.inhalt = inhalt;
    }
}