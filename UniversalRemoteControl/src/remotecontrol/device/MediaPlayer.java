package remotecontrol.device;

/**
 * Der "Receiver" des Command-Musters: der Media Player.
 * Er kennt die Fernbedienung nicht und gibt nur Meldungen auf der Konsole aus.
 */
public class MediaPlayer {

    public void on() {
        System.out.println("MediaPlayer: on");
    }

    public void off() {
        System.out.println("MediaPlayer: off");
    }

    public void play() {
        System.out.println("MediaPlayer: play");
    }

    public void pause() {
        System.out.println("MediaPlayer: pause");
    }

    public void next() {
        System.out.println("MediaPlayer: next");
    }

    public void previous() {
        System.out.println("MediaPlayer: previous");
    }
}