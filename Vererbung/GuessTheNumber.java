import java.util.Random;
import java.util.Scanner;

class Spiel {
    int maxVersuche;
    int aktuelleVersuche;
    int zielZahl;

    public Spiel(int maxVersuche) {
        this.maxVersuche = maxVersuche;
        this.aktuelleVersuche = 0;

        Random rand = new Random();
        this.zielZahl = rand.nextInt(100) + 1; // Generiere eine zufällige Zahl zwischen 1 und 100
    }

    public boolean raten(int zahl) {
        aktuelleVersuche++;

        if (zahl == zielZahl) {
            System.out.println("Herzlichen Glückwunsch! Sie haben die Zahl in " + aktuelleVersuche + " Versuchen erraten.");
            return true;
        } else if (aktuelleVersuche == maxVersuche) {
            System.out.println("Sie haben keine Versuche mehr übrig. Die richtige Zahl war " + zielZahl + ".");
            return true;
        } else {
            String hinweis = zahl < zielZahl ? "höher" : "niedriger";
            System.out.println("Die Zahl ist " + hinweis + ". Sie haben noch " + (maxVersuche - aktuelleVersuche) + " Versuche übrig.");
            return false;
        }
    }
}

class Spieler {
    String name;
    int punktzahl;

    public Spieler(String name) {
        this.name = name;
        this.punktzahl = 0;
    }

    public void erhoehePunktzahl() {
        punktzahl++;
    }
}

public class GuessTheNumber extends Spiel {
    Spieler spieler;

    public GuessTheNumber(int maxVersuche, Spieler spieler) {
        super(maxVersuche);
        this.spieler = spieler;
    }

    public void spielen() {
        System.out.println("Willkommen bei 'Guess the Number', " + spieler.name + "! Ich denke an eine Zahl zwischen 1 und 100.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Versuchen Sie zu raten: ");
            int zahl = scanner.nextInt();

            if (raten(zahl)) {
                if (aktuelleVersuche <= maxVersuche / 2) {
                    System.out.println("Wow, Sie haben schnell geraten und erhalten einen Bonuspunkt!");
                    spieler.erhoehePunktzahl();
                }

                System.out.println("Ihre aktuelle Punktzahl beträgt " + spieler.punktzahl + ".");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Spieler spieler = new Spieler("Max Mustermann");
        GuessTheNumber spiel = new GuessTheNumber(10, spieler);
        spiel.spielen();
    }
}
