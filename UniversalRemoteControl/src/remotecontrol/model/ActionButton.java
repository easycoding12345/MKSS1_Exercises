package remotecontrol.model;

import remotecontrol.command.ICommand;

/**
 * Repraesentiert einen Aktionsbutton der Fernbedienung.
 * Ein Button kennt ein Activate- und (optional) ein Deactivate-Command
 * sowie seinen aktuellen Zustand (aktiviert / deaktiviert).
 */
public class ActionButton {

    private final ICommand activate;
    private final ICommand deactivate; // null = Button ohne Activate/Deactivate-Paar
    private boolean active = false;

    public ActionButton(ICommand activate, ICommand deactivate) {
        this.activate = activate;
        this.deactivate = deactivate;
    }

    /**
     * @return true, wenn der Button ein Activate/Deactivate-Paar hat
     */
    public boolean isToggle() {
        return deactivate != null;
    }

    /**
     * Button wurde gedrueckt: fuehrt je nach Zustand Activate oder Deactivate aus.
     */
    public void press() {
        if (!isToggle()) {
            activate.execute(); // Einzelaktion, kein Zustandswechsel
            return;
        }
        if (active) {
            deactivate.execute();
        } else {
            activate.execute();
        }
        active = !active;
    }

    /**
     * Macht die zuletzt ausgefuehrte Aktion rueckgaengig, d.h. fuehrt die
     * Gegenaktion aus und setzt den Zustand des Buttons zurueck.
     */
    public void undo() {
        if (!isToggle()) {
            return; // Einzelaktionen haben keine Gegenaktion
        }
        // Zustand zuerst zurueckwechseln, dann Gegenaktion ausfuehren:
        // war der Button aktiv (Activate lief zuletzt), laeuft jetzt Deactivate - und umgekehrt
        if (active) {
            deactivate.execute();
        } else {
            activate.execute();
        }
        active = !active;
    }
}