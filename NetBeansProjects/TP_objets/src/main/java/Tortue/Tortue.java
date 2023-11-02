/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Tortue ;

import java.awt.Color;

/**
 *
 * @author christophe.varnier
 */
public class Tortue {
    private double x, y, angle ;
    private FenetreGraphique fenetre ;

    /**
     * @param fenetre la fenetre associée à la tortue
     * @param x abscisse de la tortue
     * @param y ordonnée de la tortue
     * @param angle orientation de la tortue (0 = est , 90 = nord , etc.)
    */
    public Tortue(FenetreGraphique fenetre, double x, double y, double angle) {
        this.fenetre = fenetre ;
        this.x = x ;
        this.y = y ;
        this.angle = angle ;
    }

    /**
     * fait tourner la tortue dans le sens des aiguilles d'une montre d'un angle
     * delta exprimé en degré
     * @param delta angle de rotation
     */
    public void tourne(double delta) {
        angle += delta;
    }

    /** 
     * fait avancer la tortue d'une distance dist
     * @param dist longueur du déplacement
    */
    public void avance(double dist) {
        double oldx = x;
        double oldy = y;
        x += dist * Math.cos(Math.toRadians(angle));
        y += dist * Math.sin(Math.toRadians(angle));
        fenetre.getGraphics2D().drawLine((int)oldx, (int)oldy, (int)x, (int)y);
        fenetre.repaint(100);
    }
    
    /**
     * change la couleur de tracé de la tortue
     * @param couleur nouvelle couleur du tracé
     */
    public void setCouleur(Color couleur) {
        fenetre.getGraphics2D().setColor(couleur);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
    

}
