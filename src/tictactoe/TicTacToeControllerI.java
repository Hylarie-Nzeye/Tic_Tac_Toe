package tictactoe;

/**
 * Das TicTacToeControllerI-Interface definiert die Schnittstelle für den Controller
 * des Tic Tac Toe-Spiels. Es enthält Methoden, die die Benutzerinteraktion und die
 * Spiellogik steuern.
 */
public interface TicTacToeControllerI {
    /**
     * Verarbeitet den Mausklick an den angegebenen Koordinaten und führt den
     * entsprechenden Spielzug aus.
     * @param x Die x-Koordinate des Mausklicks.
     * @param y Die y-Koordinate des Mausklicks.
     */
    void play(float x, float y);

    /**
     * Überprüft, ob das Spiel beendet ist
     * @return true, wenn das Spiel beendet ist, sonst false.
     */
    boolean isEnd();

    /**
     * Setzt das Spiel zurück und startet eine neue Runde.
     */
    void reInitialize();

    /**
     * Überprüft, ob Spieler 1 gewonnen hat.
     * @return true, wenn Spieler 1 gewonnen hat, sonst false.
     */
    boolean hasPlayer1Won();

    /**
     *  Überprüft, ob Spieler 2 gewonnen hat.
     * @return true, wenn Spieler 2 gewonnen hat, sonst false.
     */
    boolean hasPlayer2Won();

    /**
     *  Gibt das zugrunde liegende TicTacToeModel-Objekt zurück.
     * @return Das TicTacToeModel-Objekt
     */
    TicTacToeModel getM();


}
