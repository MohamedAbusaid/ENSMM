/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FenetreGraphique;


/**
 *
 * @author mabusaid
 */
public class Triangle {
    private Point p1;
    private Point p2;
    private Point p3;
    
    public Triangle(Point u, Point v, Point w){
        this.p1 = u.clone();
        this.p2 = v.clone();
        this.p3 = w.clone();     
    }
    public void Dessiner(FenetreGraphique fenetre){
        int Xp1 = this.p1.getX();
        int Xp2 = this.p2.getX();
        int Xp3 = this.p3.getX();
        int Yp1 = this.p1.getY();
        int Yp2 = this.p2.getY();
        int Yp3 = this.p3.getY();
        fenetre.getGraphics2D().drawLine(Xp1,Yp1,Xp2,Yp2);
        fenetre.getGraphics2D().drawLine(Xp2,Yp2,Xp3,Yp3);
        fenetre.getGraphics2D().drawLine(Xp3,Yp3,Xp1,Yp1);
    }
    public Triangle TriangleInscrit(){
        Triangle T = new Triangle ( p1.milieu(p2),p2.milieu(p3),p3.milieu(p1));
        return T;
    }
    public void DessinerTriangleInscrit(FenetreGraphique fenetre,int nbTriangle){
        this.Dessiner(fenetre);
        Triangle T = this.TriangleInscrit();
        for (int k = 0 ; k <= nbTriangle; k++){
            T.Dessiner(fenetre);
            T = T.TriangleInscrit();
            
        }
    }
    
    public double angleP1(){
        double opp = this.p1.dist(this.p2);
        double adj = this.p2.dist(this.p3);
        
        return Math.atan(opp/adj);
    }
    public void DessinerHomothétie(){
        
    }
    
    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }
            
}
