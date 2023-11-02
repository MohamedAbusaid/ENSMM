/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FenetreGraphique;


/**
 *
 * @author mabusaid
 */
public class Point {
    private String nom;
    private int x;
    private int y;
    
    public Point(String nom,int x ,int y){
        this.nom = nom;
        this.x = x;
        this.y = y;           
    }
    public Point clone(){
        return new Point(this.nom,this.x,this.y);
    }
    public double dist(Point B){
        double d;
        d = (this.getX()-B.getX())*(this.getX()-B.getX())+(this.getY()-B.getY())*(this.getY()-B.getY());
        return Math.sqrt(d);
    }
    public Point milieu(Point B){
        double Xm = (this.getX()+B.getX())/2;
        double Ym = (this.getY()+B.getY())/2;        
        Point m = new Point("M",(int) Xm,(int) Ym);
        return m;
    }
    
    
    public String getNom() {
        return nom;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}

