package tictactoe;

/**
 * Der TicTacToeController steuert die Spiellogik und Benutzereingabe für das Tic Tac Toe-Spiel.
 *  Hier werden Mausklicks verarbeitet und Spielzüge ausgeführt.
 */

public class TicTacToeController implements TicTacToeControllerI{
    private TicTacToeModel m;
    private TicTacToeViewI v;

    /**
     * Verarbeitet den Mausklick und führt den Spielzug aus.
     * @param x Die x-Koordinate des Mausklicks.
     * @param y Die y-Koordinate des Mausklicks.
     */
    public void play(float x, float y){
        int field = showField(x,y,v.getWidth(),v.getHeight());
        this.m.move(field);
    }

    /**
     * Ermittelt das Spielfeld anhand der Mauskoordinaten.
     * @param x   Die x-Koordinate des Mausklicks.
     * @param y    Die y-Koordinate des Mausklicks.
     * @param width   Die Breite des Spielfelds.
     * @param height  Die Höhe des Spielfelds.
     * @return Die Spielfeldposition (0-8).
     */
    public int showField(float x, float y,float width,float height){
        if(x<width/3 && x>0 && y<height/3 && y>0){
            return 0;
        }else if(x>width/3 && x<(2*width)/3 && y<height/3 && y>0){
            return 1;
        }else if(x<width && x>(2*width)/3 && y<height/3 && y>0){
            return 2;
        }else if(x<width/3 && x>0 && y<(2*height)/3 && y>height/3){
            return 3;
        }else if(x>width/3 && x<(2*width)/3 && y<(2*height)/3 && y>height/3){
            return 4;
        }else if(x<width && x>(2*width)/3 && y<(2*height)/3 && y>height/3){
            return 5;
        }else if(x<width/3 && x>0 && y<height && y>(2*height)/3){
            return 6;
        }else if(x>width/3 && x<(2*width)/3 && y<height && y>(2*height)/3){
            return 7;
        }else{
            return 8;
        }
    }

    /**
     *   Überprüft, ob das Spiel beendet ist.
     * @return   true, wenn das Spiel beendet ist, sonst false.
     */
    public boolean isEnd(){
        return m.isGameOver();
    }

    /**
     * Überprüft, ob Spieler 1 gewonnen hat.
     * @return    true, wenn Spieler 1 gewonnen hat, sonst false.
     */
    public boolean hasPlayer1Won(){
        return m.hasPlayer1Won();
    }

    /**
     * Überprüft, ob Spieler 2 gewonnen hat.
     * @return true, wenn Spieler 2 gewonnen hat, sonst false.
     */
    public boolean hasPlayer2Won(){
        return m.hasPlayer2Won();
    }

    /**
     * Setzt das Spiel zurück und initialisiert es neu.
     */
    public void reInitialize(){
        this.m= new TicTacToeModel();
    }

    /**
     * Setzt die zugehörige View für den Controller.
     * @param v Die View.
     */
    public void setV(TicTacToeView v) {
        this.v = v;
    }

    /**
     *  Gibt das Model zurück.
     * @return  Das TicTacToeModel.
     */
    public TicTacToeModel getM() {
        return m;
    }

    /**
     *  Setzt das Model für den Controller.
     * @param m  Das TicTacToeModel.
     */
    public void setM(TicTacToeModel m) {
        this.m = m;
    }
}
