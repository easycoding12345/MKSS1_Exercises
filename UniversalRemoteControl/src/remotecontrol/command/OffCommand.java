package remotecontrol.command;

import remotecontrol.device.MediaPlayer;

/**
 * Konkretes Command: ruft off() auf dem MediaPlayer auf.
 */
public class OffCommand implements ICommand {

    private final MediaPlayer player;

    public OffCommand(MediaPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.off();
    }
}