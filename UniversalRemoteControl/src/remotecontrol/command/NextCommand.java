package remotecontrol.command;

import remotecontrol.device.MediaPlayer;

/**
 * Konkretes Command: ruft next() auf dem MediaPlayer auf.
 */
public class NextCommand implements ICommand {

    private final MediaPlayer player;

    public NextCommand(MediaPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.next();
    }
}