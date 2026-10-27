package remotecontrol.command;

import remotecontrol.device.MediaPlayer;

/**
 * Konkretes Command: ruft play() auf dem MediaPlayer auf.
 */
public class PlayCommand implements ICommand {

    private final MediaPlayer player;

    public PlayCommand(MediaPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.play();
    }
}