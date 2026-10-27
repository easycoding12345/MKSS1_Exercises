package remotecontrol.command;

import remotecontrol.device.MediaPlayer;

/**
 * Konkretes Command: ruft on() auf dem MediaPlayer auf.
 */
public class OnCommand implements ICommand {

    private final MediaPlayer player;

    public OnCommand(MediaPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.on();
    }
}