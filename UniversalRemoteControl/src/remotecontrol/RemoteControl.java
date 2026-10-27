package remotecontrol;

import java.util.ArrayDeque;
import java.util.Deque;
import remotecontrol.command.ICommand;
import remotecontrol.model.ActionButton;

/**
 *  Base implementation for the remote control.
 */
public class RemoteControl implements IRemoteControl {

    public final static int NO_OF_ACTION_BUTTONS = 3;

    // Datenstruktur fuer die Aktionsbuttons (Array, Index = Buttonnummer)
    private final ActionButton[] actionButtons;
    // Datenstruktur fuer Undo-Button / Historie: Stack der zuletzt gedrueckten (undo-baren) Buttons
    private final Deque<ActionButton> history;

    public RemoteControl() {
        // Aktionsbuttons initialisieren (zunaechst unkonfiguriert = null)
        actionButtons = new ActionButton[NO_OF_ACTION_BUTTONS];
        // Historie initialisieren
        history = new ArrayDeque<>();
    }

    @Override
    public void setActionButton(int no, ICommand activate, ICommand deactivate) {
        checkButtonNumber(no);
        actionButtons[no] = new ActionButton(activate, deactivate);
    }

    @Override
    public void setActionButton(int no, ICommand action) {
        checkButtonNumber(no);
        actionButtons[no] = new ActionButton(action, null);
    }

    /**
     * The action button was pressed.
     * Depending on its status, it will execute an activate or deactivate action.
     *
     * @param no The number of the button.
     */
    @Override
    public void actionButtonPressed(int no) {
        checkButtonNumber(no);
        ActionButton button = actionButtons[no];
        if (button == null) {
            System.out.println("Button " + no + " ist nicht konfiguriert.");
            return;
        }
        // Aktion entsprechend dem Buttonstatus ausfuehren
        button.press();
        // Undo-Historie aktualisieren (nur Buttons mit Gegenaktion sind undo-bar)
        if (button.isToggle()) {
            history.push(button);
        }
    }

    /**
     * The undo button was pressed.
     * It will undo the previous action.
     */
    @Override
    public void undoButtonPressed() {
        if (history.isEmpty()) {
            System.out.println("Nichts rueckgaengig zu machen.");
            return;
        }
        // Letzte Aktion rueckgaengig machen (Gegenaktion ausfuehren)
        history.pop().undo();
    }

    private void checkButtonNumber(int no) {
        if (no < 0 || no >= NO_OF_ACTION_BUTTONS) {
            throw new IllegalArgumentException("Ungueltige Buttonnummer: " + no);
        }
    }
}