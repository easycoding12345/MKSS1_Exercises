package remotecontrol;

import remotecontrol.command.ICommand;

/**
 * Interface for a generic remote control.
 */
public interface IRemoteControl {

    /**
     * Konfiguriert einen Aktionsbutton mit einem Paar aus Activate- und Deactivate-Aktion.
     *
     * @param no         Die Nummer des Buttons.
     * @param activate   Aktion beim 1., 3., 5. ... Druck.
     * @param deactivate Aktion beim 2., 4., 6. ... Druck.
     */
    void setActionButton(int no, ICommand activate, ICommand deactivate);

    /**
     * Konfiguriert einen Aktionsbutton mit nur einer Aktion (ohne Activate/Deactivate-Wechsel),
     * z.B. fuer eine zukuenftige Fernbedienung mit sechs Buttons.
     *
     * @param no     Die Nummer des Buttons.
     * @param action Aktion, die bei jedem Druck ausgefuehrt wird.
     */
    void setActionButton(int no, ICommand action);

    /**
     * The action button was pressed.
     * Depending on its status, it will execute an activate or deactivate action.
     *
     * @param no The number of the button.
     */
    void actionButtonPressed(int no);

    /**
     * The undo button was pressed.
     * It will undo the previous action.
     */
    void undoButtonPressed();
}