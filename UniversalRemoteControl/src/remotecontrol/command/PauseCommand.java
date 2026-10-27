package remotecontrol.command;

import remotecontrol.device.MediaPlayer;

/**
 * Konkretes Command: ruft pause() auf dem MediaPlayer auf.
 */
public class PauseCommand implements ICommand {

    private final MediaPlayer player;

    public PauseCommand(MediaPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.pause();
    }
}