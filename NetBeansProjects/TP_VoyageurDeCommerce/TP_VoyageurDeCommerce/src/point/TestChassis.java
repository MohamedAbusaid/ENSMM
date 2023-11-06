/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package point;

import FenetreGraphique.FenetreGraphique;
import chemin.Chemin;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author guillaume.laurent
 */
public class TestChassis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        ArrayList<Point> listePoints = new ArrayList<>();

        // aile
        listePoints.add(new Point(89, 245));
        listePoints.add(new Point(125, 237));
        listePoints.add(new Point(150, 245));        
        listePoints.add(new Point(189, 279));        
        listePoints.add(new Point(162, 226));

        // portiere avant
        listePoints.add(new Point(238, 184));
        listePoints.add(new Point(293, 312));
        listePoints.add(new Point(287, 158));
        listePoints.add(new Point(339, 141));
        listePoints.add(new Point(214, 294));
        listePoints.add(new Point(401, 133));
        listePoints.add(new Point(389, 188));
        listePoints.add(new Point(204, 202));
        listePoints.add(new Point(383, 240));
        listePoints.add(new Point(376, 281));
        listePoints.add(new Point(340, 312));
        listePoints.add(new Point(244, 311));
        listePoints.add(new Point(213, 249));        
        listePoints.add(new Point(197, 317));

        // portiere avant
        listePoints.add(new Point(421, 137));
        listePoints.add(new Point(493, 139));
        listePoints.add(new Point(594, 165));
        listePoints.add(new Point(559, 220));
        listePoints.add(new Point(520, 282));
        listePoints.add(new Point(487, 308));
        listePoints.add(new Point(436, 310));
        listePoints.add(new Point(409, 291));
        listePoints.add(new Point(414, 218));
        
        FenetreGraphique fenetre = new FenetreGraphique("Chassis", 800, 457);
        BufferedImage image = ImageIO.read(new File("chassis.jpg"));
        fenetre.getGraphics2D().drawImage(image, 0, 0, null);
        fenetre.getGraphics2D().setColor(Color.RED);
        
        for (int i = 0; i < listePoints.size(); i++) {
            listePoints.get(i).dessiner(fenetre.getGraphics2D());          
        }
        
        
        Chemin ch = new Chemin(listePoints);
//        ch.afficher_chemin();
        ch.balayage_angulaire();
//        ch.afficher_chemin();
        ch.iterative_2op();
//        ch.afficher_chemin();
        ch.interchanger(9,16);
//        ch.afficher_chemin();
        ch.iterative_2op();
//        ch.afficher_chemin();
        ch.interchanger(5,15);
        ch.afficher_chemin_surIMG(fenetre);
        fenetre.actualiser();
        fenetre.enregistrerImage("soudures.png");
    }
    
}
