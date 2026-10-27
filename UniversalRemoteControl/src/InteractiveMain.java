import remotecontrol.RemoteControl;
import remotecontrol.command.*;
import remotecontrol.device.MediaPlayer;

import java.util.Scanner;

/**
 * Interaktives Testprogramm: Der Benutzer bedient die Fernbedienung ueber die Konsole.
 * Die eigentliche Testsequenz der Aufgabe befindet sich weiterhin in Main.
 */
public class InteractiveMain {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        MediaPlayer player = new MediaPlayer();

        // Gleiche Konfiguration wie in Main
        remote.setActionButton(0, new OnCommand(player), new OffCommand(player));
        remote.setActionButton(1, new PlayCommand(player), new PauseCommand(player));
        remote.setActionButton(2, new NextCommand(player), new PreviousCommand(player));

        printHelp();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            if (!scanner.hasNextLine()) {
                break; // Eingabe zu Ende (z.B. Ctrl+D / Ctrl+Z)
            }
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "0", "1", "2" -> remote.actionButtonPressed(Integer.parseInt(input));
                case "u" -> remote.undoButtonPressed();
                case "h" -> printHelp();
                case "q" -> {
                    System.out.println("Programm beendet.");
                    return;
                }
                case "" -> { } // leere Eingabe ignorieren
                default -> System.out.println("Unbekannte Eingabe. 'h' zeigt die Hilfe.");
            }
        }
    }

    private static void printHelp() {
        System.out.println("=== Universal Remote Control ===");
        System.out.println("0 = Button 0 (on / off)");
        System.out.println("1 = Button 1 (play / pause)");
        System.out.println("2 = Button 2 (next / previous)");
        System.out.println("u = Undo");
        System.out.println("h = Hilfe");
        System.out.println("q = Beenden");
    }
}