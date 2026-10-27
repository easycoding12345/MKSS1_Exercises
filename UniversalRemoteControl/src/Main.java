import remotecontrol.RemoteControl;
import remotecontrol.command.*;
import remotecontrol.device.MediaPlayer;

/**
 * Main for testing the functionality
 */
public class Main {
	public static void main(String[] args) {
		RemoteControl mediaPlayerRemote = new RemoteControl();

		// Receiver: der Media Player
		MediaPlayer player = new MediaPlayer();

		// Buttons mit Activate-/Deactivate-Aktionen konfigurieren
		mediaPlayerRemote.setActionButton(0, new OnCommand(player), new OffCommand(player));
		mediaPlayerRemote.setActionButton(1, new PlayCommand(player), new PauseCommand(player));
		mediaPlayerRemote.setActionButton(2, new NextCommand(player), new PreviousCommand(player));

		// Funktionalitaet testen
		mediaPlayerRemote.actionButtonPressed(0);
		mediaPlayerRemote.actionButtonPressed(1);
		mediaPlayerRemote.actionButtonPressed(2);

		mediaPlayerRemote.undoButtonPressed();

		mediaPlayerRemote.actionButtonPressed(1);

		mediaPlayerRemote.undoButtonPressed();
		mediaPlayerRemote.undoButtonPressed();

		mediaPlayerRemote.actionButtonPressed(0);
	}
}