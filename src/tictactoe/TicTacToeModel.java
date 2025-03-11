package tictactoe; /** A basic model to play Tic Tac Toe with two players. Supports basic JShell output.
         *
         * Example:
         * jshell> /open TicTacToeModel.java *
        * jshell> var game = new TicTacToeModel()
        * game ==> Make move for X
        * _ _ _
        * _ _ _
        * _ _ _
        *
        * jshell> game.move(1)
        * Make move for O
        * _ X _
        * _ _ _
        * _ _ _
        *
        * jshell> game.move(4)
        * Make move for X
        * _ X _
        * _ O _
        * _ _ _
        */

/**
 * Das TicTacToeModel repraesentiert den Zustand und die Logik des TicTacToe-Spiels.
 * Es implementiert die grundlegenden Funktionen fuer das Spielen und ueberpruefen des Spielzustand.
 */
public class TicTacToeModel {
        /**
         * Das Standardfeld fuer leere Spielfelder
         */
        public final char EMPTY = '_';
        /**
         * Das Markierungszeichen fuer Spieler 1 auf dem Spielfeld
         */
        public final char PLAYER_1 = 'X';
        /**
         * Das Markierungszeichen fuer Spieler 2 auf dem Spielfeld
         */
        public final char PLAYER_2 = 'O';

        /**
         * Das Spielfeld mit 9 Einträgen
         */
        private char[] gameState;

        /**
         * Zählt die Züge. Gerade Züge sind für SPIELER_1; ungerade Züge sind für SPIELER_2.
         */
        private char moveCount = 0;

    /*public static void main(String[] args) {
        var game = new TicTacToeModel();
        game.move(1);
        game.move(2);
        game.move(4);
        System.out.println("Field 4 is: "+ game.getFieldEntry(4));
    }*/

        /**
         * Konstruktor fuer das TicTacToeModel und dient dazu ein neues Spiel zu erzeugen.
         */
        public TicTacToeModel() {
                newGame();
        }

        /**
         * Startet ein neues Spiel, setzt das Spielfeld zurück und initialisiert den Zugzaehler.
         */
        public void newGame() {
                gameState = new char[]
                        {EMPTY, EMPTY, EMPTY,
                                EMPTY, EMPTY, EMPTY,
                                EMPTY, EMPTY, EMPTY};
                moveCount = 0;
        }

        /**
         * getFieldEntry gibt das Zeichen an der angegebenen Position auf dem Spielfeld zurueck.
         *
         * @param field das Spieldfeld (0-8)
         * @return Das Zeichnen an der Position
         * @throws IndexOutOfBoundsException wenn die Position ungültig ist
         */
        public char getFieldEntry(int field) {
                if (isValidFieldIndex(field))
                        return gameState[field];

        else
                        throw new IndexOutOfBoundsException("Valid fields are [0, 8]");
        }
        /**
         * Gibt das aktuelle Spielfeld zurück.
         *
         * @return Das Spielfeld als char-Array
         */
        public char[] getBoard() {
                return gameState;
        }

        /**
         * isValidFieldIndex
         *
         * @param field
         * @return
         */
        public boolean isValidFieldIndex(int field) {
                return field >= 0 && field < gameState.length;
        }

        /**
         * isEmptyField ueberprueft,ob das Feld auf dem Spieldfeld leer ist.
         *
         * @param field Das Spielfeld(0-8)
         * @return true, wenn das Spielfeld leer ist.
         * @throws IndexOutOfBoundsException wenn die Position ungueltig ist.
         */
        public boolean isEmptyField(int field) {
                if (isValidFieldIndex(field))
                        return gameState[field] == EMPTY;
                else
                        throw new IndexOutOfBoundsException("Valid fields are [0, 8]");
        }

        /**
         * getActivePlayer gibt das Zeichen des aktiven Spieler
         *
         * @return Das Zeichen des aktiven  Spieler
         */
        public char getActivePlayer() {
                return (moveCount % 2 == 0) ? PLAYER_1 : PLAYER_2;
        }

        /**
         * move setzt den Eintrag fuer ein bestimmtes Feld mit dem Zeichen des aktiven Spielers.
         *
         * @param field das Feld, fuer das den Eintrag gesetzt wird
         * @throws IndexOutOfBoundsException falls das Feld ungültig ist.
         * @throws RuntimeException          falls das gewaelte Feld schon beleg ist.
         * @throws RuntimeException          falls das Spiel bereits vorbei ist.
         */
        public void move(int field) {
                if (!isGameOver()) {
                        if (!isValidFieldIndex(field))
                                throw new IndexOutOfBoundsException("Valid fields are [0, 8]");
                        if (!isEmptyField(field))
                                throw new RuntimeException("The chosen field is already taken");

                        gameState[field] = getActivePlayer();
                        moveCount++;

                        // Print the state after the move. For easier play inside the JShell.
                        System.out.println(this);
                } else
                        throw new RuntimeException("The game is already over. Please start a new game.");
        }

        public boolean isGameOver() {
                return hasPlayer1Won() || hasPlayer2Won() || moveCount >= gameState.length;
        }

        /**
         * hasPlayer1Won ueberprueft,ob das Spieler 1 gewonnen hat.
         *
         * @return true, wenn Spieler 1 gewonnen hat.
         */
        public boolean hasPlayer1Won() {
                return checkWinCondition(PLAYER_1);
        }

        /**
         * hasPlayer2Won ueberprueft,ob das Spieler 2 gewonnen hat.
         *
         * @return true, wenn Spieler 2 gewonnen hat.
         */
        public boolean hasPlayer2Won() {
                return checkWinCondition(PLAYER_2);
        }

        /**
         * checkWinCondition ueberprueft die Siegbedingung eines Spielers.
         *
         * @param player Der Player,dessen Sieg ueberprueft.
         * @return true, wenn der Spieler gewonnen hat.
         */
        private boolean checkWinCondition(char player) {
                return  // Check rows
                        (gameState[0] == player && gameState[1] == player && gameState[2] == player) ||
                                (gameState[3] == player && gameState[4] == player && gameState[5] == player) ||
                                (gameState[6] == player && gameState[7] == player && gameState[8] == player) ||
                                // Check columns
                                (gameState[0] == player && gameState[3] == player && gameState[6] == player) ||
                                (gameState[1] == player && gameState[4] == player && gameState[7] == player) ||
                                (gameState[2] == player && gameState[5] == player && gameState[8] == player) ||
                                // Check diagonals
                                (gameState[0] == player && gameState[4] == player && gameState[8] == player) ||
                                (gameState[2] == player && gameState[4] == player && gameState[6] == player);
        }

        /**
         * toString ist die Repraesention des aktuellen Spiel
         *
         * @return Eine Zeichenkette mit der aktuellen Zustand des Spieles
         */
        @Override
        public String toString() {
                return String.format("%s\n%c %c %c\n%c %c %c\n%c %c %c",
                        isGameOver() ? "Game Over" : "Make move for " + getActivePlayer(),
                        gameState[0], gameState[1], gameState[2],
                        gameState[3], gameState[4], gameState[5],
                        gameState[6], gameState[7], gameState[8]);
        }

        /**
         * getGameState gibt das aktuelle Spielfeld zurueck
         *
         * @return ein char-Array,das das Spielfeld ist.
         */
        public char[] getGameState() {
                return gameState;
        }

        /**
         * getPlayer_1 gibt das Zeichen des player1 zurueck.
         *
         * @return Das Zeichen des Spielers 1
         */
        public char getPLAYER_1() {
                return PLAYER_1;
        }

        /**
         * getPlayer2 gibt das Zeichen des Player2 zurueck
         *
         * @return Das Zeichen des Spielers 2
         */
        public char getPLAYER_2() {
                return PLAYER_2;
        }

        /**
         * Gibt die Anzahl der bisherigen Spielzüge zurück.
         *
         * @return Die Anzahl der bisherigen Spielzüge.
         */
        public int getMoveCount() {
                return moveCount;
        }
}