package tictactoe;


import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

import javax.swing.*;
/**
 * Die Klasse TicTacToeView implementiert die Benutzeroberfläche für das Tic Tac Toe-Spiel.
 * Sie erweitert die PApplet-Klasse und implementiert das TicTacToeViewI-Interface.
 */
public class TicTacToeView extends PApplet implements TicTacToeViewI{
    /**
     * Die zugehörige Controller-Schnittstelle.
     */
    protected TicTacToeControllerI c;
    /**
     * Das Bild für Spieler 1 und 2.
     */
    PImage player1,player2;

    /**
     * Ein Grafikobjekt für die Verarbeitung.
     */
    String i;



    /**
     * Konstruktor für TicTacToeView, der ein neues Grafikobjekt erstellt.
     */
    public TicTacToeView(){
        this.g=new PGraphics();
    }

    /**
     * Setzt den zugehörigen Controller.
     * @param c Der zugehörige Controller.
     */
    public void setC(TicTacToeController c) {
        this.c = c;
    }

    /**
     * Einstellungen für die Größe des Fensters.
     */
    public void settings() {
        setSize(600, 400);
    }
    /**
     * Initialisiert die Ansichtseinstellungen, lädt Spielerbilder und setzt den Zustand des Spiels.
     */
    public void setup() {
        background(255,255,255);
        player1=loadImage("images/035.png");
        player2=loadImage("images/114.png");
        i="j";
    }
    /**
     * Zeichnet das Spielfeld und Spielsteine basierend auf dem Zustand des Spiels.
     */
    public void draw() {
        background(255);
        strokeWeight(5);
        line((float)width/3,0,(float)width/3,height);
        line((float)(2*width)/3,0,(float)(2*width)/3,height);
        line(0,(float)height/3,width,(float)height/3);
        line(0,(float)(2*height)/3,width,(float)(2*height)/3);

        //float hRelativ=0;
        if(i.equalsIgnoreCase("j")){
            if (!c.isEnd()){
                for(int i=0;i<c.getM().getBoard().length;i++){
                    char ch=c.getM().getBoard()[i];
                    if(ch=='X'){
                        image(player1,(i%3)* (float)(width/3),((int)(i/3))*((float)height/3),(float)width/3,(float)height/3);
                    }
                    if(ch=='O'){
                        image(player2,(i%3)* (float)(width/3),((int)(i/3))*((float)height/3),(float)width/3,(float)height/3);
                    }
                }
            }
            else {
                drawGO();
                i = JOptionPane.showInputDialog("Moechten ein neues Spiel starten ? 'j' druecken, falls ja und 'n', falls Nein");
                if (i.equalsIgnoreCase("j")) {
                    c.reInitialize();
                }else{
                    i="n";
                }
            }
        }else{
            drawGB();
        }



    }
    /**
     * Verarbeitet den Mausklick und führt den Spielzug aus.
     */
    public void mousePressed(){
        c.play(mouseX,mouseY);
    }
    /**
     * Zeichnet den Bildschirm mit einer Spielende-Nachricht.
     */
    public void drawGO() {
        String end= "Nobody won";
        if(c.hasPlayer1Won()){
            end="Player 1 won";
        }
        if(c.hasPlayer2Won()){
            end="Player 2 won";
        }
        background(0);
        textSize(64);
        text("GAME OVER! \n"+end, 100, 100);
    }
    /**
     * Zeichnet den Bildschirm mit einer Abschiedsnachricht.
     */
    public void drawGB(){
        background(0);
        textSize(64);
        text("GOOD-BYE! \n", 100, 100);
    }

    /**
     * Startet die Anwendung neu, wenn der Benutzer dies wünscht.
     */
    public void restart(){
        String i= JOptionPane.showInputDialog("Moechten ein neues Spiel starten, 'j' druecken, falls ja und 'n', falls Nein");
        if (i.equalsIgnoreCase("j")){
            c.reInitialize();
        }
        else if(i.equalsIgnoreCase("n")){
            drawGB();
        }
    }

    /**
     * Gibt die Breite des Fensters zurück.
     * @return Die Breite des Fensters.
     */
    public float getWidth(){
        return width;
    }

    /**
     * Gibt die Breite des Fensters zurück.
     * @return Die Breite des Fensters.
     */
    public float getHeight(){
        return height;
    }
}
