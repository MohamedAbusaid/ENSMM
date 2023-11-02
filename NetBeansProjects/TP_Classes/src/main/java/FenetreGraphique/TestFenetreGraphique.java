/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package FenetreGraphique;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author guillaume.laurent
 */
public class TestFenetreGraphique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        FenetreGraphique fenetre = new FenetreGraphique("Hello World!", 1000, 1000);

//        fenetre.getGraphics2D().setColor(Color.RED);
//        fenetre.getGraphics2D().drawLine(10, 10, 60, 160);
//
//        fenetre.getGraphics2D().setColor(Color.GREEN);
//        fenetre.getGraphics2D().drawRect(10, 10, 50, 30);
//
//        fenetre.getGraphics2D().setColor(Color.BLUE);
//        fenetre.getGraphics2D().fillOval(200, 10, 20, 10);
//
//        fenetre.getGraphics2D().drawString("Hello world!", 200, 50);
        Point A = new Point("A",500,500);
        Point B = new Point("B",540,500);
        Point C = new Point("C",540, 530);
        Triangle triangleI = new Triangle(A,B,C);
        triangleI.Dessiner(fenetre);
        
        
        fenetre.actualiser();

    }

}
