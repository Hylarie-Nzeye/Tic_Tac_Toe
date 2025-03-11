package tictactoe;

/**
 * Das Interface TicTacToeViewI definiert den Vertrag für eine Tic Tac Toe-Ansicht.
 *  Es bietet Methoden zum Abrufen der Breite und Höhe der Ansicht.
 */
public interface TicTacToeViewI {
    /**
     *Gibt die Breite der Ansicht zurück.
     * @return    Die Breite der Ansicht.
     */
    float getWidth();

    /**
     * Gibt die Höhe der Ansicht zurück.
     * @return  Die Höhe der Ansicht.
     */
    float getHeight();

}
