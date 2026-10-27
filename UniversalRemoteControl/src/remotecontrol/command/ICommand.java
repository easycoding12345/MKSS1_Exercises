package remotecontrol.command;

/**
 * Command-Interface (Entwurfsmuster "Command").
 * Kapselt eine Aktion, die von der Fernbedienung ausgeloest werden kann.
 */
public interface ICommand {

    /**
     * Fuehrt die Aktion aus.
     */
    void execute();
}