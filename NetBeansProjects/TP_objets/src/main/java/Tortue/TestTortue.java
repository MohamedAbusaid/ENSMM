/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tortue;

import Clavier.Clavier;
import java.awt.Color;

/**
 *
 * @author guillaume.laurent
 */
public class TestTortue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        FenetreGraphique fenetre = new FenetreGraphique("Test de la tortue", 300, 270);
//
//        Tortue turtle = new Tortue(fenetre,150,125,0) ;
//        Color coul = Color.BLUE ;
//        turtle.setCouleur(coul);
//        turtle.tourne(45);
//        turtle.avance(150);
//
//        turtle = new Tortue(fenetre,15,100,0) ;
//        coul = Color.GRAY ;
//        turtle.setCouleur(coul);
//        turtle.avance(100);
//        turtle.tourne(90);
//        turtle.avance(100);
//        turtle.tourne(90);
//        turtle.avance(100);
//        turtle.tourne(90);
//        turtle.avance(100);
//        turtle.tourne(45);
//        turtle.avance(70);
//        turtle.tourne(90);
//        turtle.avance(70);
//        FenetreGraphique fenetre = new FenetreGraphique("POLYGONE", 500, 500);
//        
//        System.out.println("Donnez un nombre de cotes");
//        int n = Clavier.getInt();
//        System.out.println("Donnez une longueur");
//        int l = Clavier.getInt();
//        
//        Tortue turtle = new Tortue(fenetre,150,100,0);
//        Color coul = Color.BLACK;
//        turtle.setCouleur(coul);
//        
//        for (int i = 1 ; i <= n ; i++){
//            turtle.avance(l);
//            turtle.tourne(360/n);
//        }
        FenetreGraphique fenetre = new FenetreGraphique("ROSACE", 1000, 1000);
        
        System.out.println("Donnez un nombre de cotes");
        int n = Clavier.getInt();
        System.out.println("Donnez une longueur");
        int l = Clavier.getInt();
        
        Tortue turtle = new Tortue(fenetre,500,500,0);
        Color coul = Color.BLACK;
        turtle.setCouleur(coul);
        int angle = 360 / n;
        for(int k = 0 ; k <= 360 ; k = k +10){
            for (int i = 1 ; i <= n ; i++){
            turtle.avance(l);
            turtle.tourne(angle);
            }
            turtle.tourne(k);
        }
         
        fenetre.repaint();
    }

}
