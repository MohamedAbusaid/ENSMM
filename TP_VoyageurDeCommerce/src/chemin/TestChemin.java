/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chemin;

import FenetreGraphique.FenetreGraphique;
import java.awt.Color;
import point.Point;

/**
 *
 * @author mabusaid
 */
public class TestChemin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Point A = new Point(1.00,2.00);
        Point B = new Point(10.5,3.7);
        Point C = new Point(20,30);
        Point D = new Point(15,50);
        Point E = new Point(50,28);
        Point F = new Point(19.00,80.00);
        Point G = new Point(1.00,66.00);
        Point H = new Point(45.00,20.00);
        Point I = new Point(20.00,45.00);
        Point J = new Point(15.00,30.00);
        Chemin ch = new Chemin();
        ch.ajouter_point(A);
        ch.ajouter_point(B);
        ch.ajouter_point(C);
        ch.ajouter_point(D);
        ch.ajouter_point(E);
        ch.ajouter_point(F);
        ch.ajouter_point(G);
        ch.ajouter_point(H);
        ch.ajouter_point(I);
        ch.ajouter_point(J);
        ch.melanger();
        System.out.println(ch.toString());
        ch.afficher_chemin();
        
        
        
    }
    
}
