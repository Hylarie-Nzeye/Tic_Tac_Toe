package tictactoe;

import processing.core.PApplet;
/**
 *Die Main-Klasse dient als Einstiegspunkt für das Tic Tac Toe-Spiel.
 *  Hier werden die Hauptkomponenten (Model, Controller und View) initialisiert und verbunden.
 * Es ermöglicht auch die Konfiguration von Sprache und Modus über die Konsole.
 */
public final class Main{
    /**
     *  Die Hauptmethode, die beim Start des Programms aufgerufen wird.
     * @param args Die Befehlszeilenargumente (nicht verwendet).
     */
    public static void main(String[] args) {
/**
 * Initialisierung von Model, Controller und View
  */

        var model = new TicTacToeModel();
        var controller = new TicTacToeController();
        var view = new TicTacToeView();
        /**
         *  Verbindung von Model, Controller und View
          */
        controller.setM(model);
        controller.setV(view);
        view.setC(controller);
        /**
         * Starten der Benutzeroberfläche
         */
        PApplet.runSketch(new String[]{"TicTacToe"}, view);

    }





}
