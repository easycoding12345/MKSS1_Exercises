package remotecontrol.command;

import remotecontrol.device.MediaPlayer;

/**
 * Konkretes Command: ruft previous() auf dem MediaPlayer auf.
 */
public class PreviousCommand implements ICommand {

    private final MediaPlayer player;

    public PreviousCommand(MediaPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.previous();
    }
}