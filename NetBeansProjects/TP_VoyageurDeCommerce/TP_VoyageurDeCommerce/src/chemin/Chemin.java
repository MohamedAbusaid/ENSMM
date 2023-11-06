/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chemin;

import FenetreGraphique.FenetreGraphique;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import point.Point;
/**
 *
 * @author mabusaid
 */
public class Chemin {
    private ArrayList<Point> liste_point;

    public Chemin() {
        this.liste_point = new ArrayList<Point>();
    }
    public Chemin(ArrayList<Point> liste){
        this.liste_point = liste;
    }
    public void ajouter_point(Point point){
        this.liste_point.add(point);
    }
    public boolean presence_point(Point point){
        boolean reponse = false;
        int i = 0;
        while (reponse == false && i < this.liste_point.size()){
            if (this.liste_point.get(i).equals(point)){
                reponse = true;
            }
        }
        return reponse;
    }
    public boolean presence_point_contains(Point point){
        if (this.liste_point.contains(point)){
            return true;
        }
        return false;
    }
    public double longueure_totale(){
        double distance_totale = 0;
        for(int i = 1 ; i < this.liste_point.size();i++){
            distance_totale = distance_totale + this.liste_point.get(i-1).distance(this.liste_point.get(i));
        }
        return distance_totale;
    }
    public void melanger(){
        Collections.shuffle(this.liste_point);
    }
    public String toString(){
       String L = "";
       for (int i = 0 ; i < this.liste_point.size(); i++){
           L = L + this.liste_point.toString();       
        }
       return "Le chemin contient les points " + L;
    }
    public void afficher_chemin(){
        FenetreGraphique fenetre = new FenetreGraphique("Affichage Chemin", 800, 457 );
        fenetre.getGraphics2D().setColor(Color.RED);
        int X;
        int Y;
        int X1;
        int Y1;
        for (int i = 1 ; i < this.liste_point.size();i++){
            X = (int)this.liste_point.get(i-1).getX();
            Y = (int)this.liste_point.get(i-1).getY();
            X1 = (int)this.liste_point.get(i).getX();
            Y1 = (int)this.liste_point.get(i).getY();
            fenetre.getGraphics2D().drawLine(X,Y,X1,Y1);
        }
    }
        public void afficher_chemin_surIMG(FenetreGraphique fenetre){
        int X;
        int Y;
        int X1;
        int Y1;
        for (int i = 1 ; i < this.liste_point.size();i++){
            X = (int)this.liste_point.get(i-1).getX();
            Y = (int)this.liste_point.get(i-1).getY();
            X1 = (int)this.liste_point.get(i).getX();
            Y1 = (int)this.liste_point.get(i).getY();
            fenetre.getGraphics2D().drawLine(X,Y,X1,Y1);
        }
    }
    public Point barycentre(){
        double Xb = this.liste_point.get(0).getX();
        double Yb = this.liste_point.get(0).getX();
        for (int i = 1 ; i < this.liste_point.size();i++){
            Xb = Xb + this.liste_point.get(i).getX();
            Yb = Yb + this.liste_point.get(i).getY();
        }
        Point P = new Point(Xb/this.liste_point.size(),Yb/this.liste_point.size());
        return P;
    }
    public void translater(Point P){
        for (int i = 1 ; i < this.liste_point.size();i++){
            this.liste_point.get(i).setX(this.liste_point.get(i).getX()+P.getX());
            this.liste_point.get(i).setY(this.liste_point.get(i).getY()+P.getY());
        }
    }
    public void classer_coord_polaires(){
        Collections.sort(this.liste_point);
    }
    public void balayage_angulaire(){
        Point Barycentre = this.barycentre();
        double Xb = Barycentre.getX();
        double Yb = Barycentre.getY();   
        double Xi;
        double Yi;
        for (int i = 0 ; i < this.liste_point.size();i++){
            Xi = this.liste_point.get(i).getX();
            Yi = this.liste_point.get(i).getY();  
            this.liste_point.get(i).setX(Xi - Xb);
            this.liste_point.get(i).setY(Yi - Yb);
        }
        this.classer_coord_polaires();
        for (int i = 0 ; i < this.liste_point.size();i++){
            Xi = this.liste_point.get(i).getX();
            Yi = this.liste_point.get(i).getY();  
            this.liste_point.get(i).setX(Xi + Xb);
            this.liste_point.get(i).setY(Yi + Yb);
        }
    }
       
    public void heuristique(){
        ArrayList<Point> Q = new ArrayList<Point>();
        Point P = this.liste_point.get(0);
        this.liste_point.remove(P);
        Q.add(P);
        while (this.liste_point.size()>0){
            int indice_pt = this.indice_PPV(P);
            double Xp = this.liste_point.get(indice_pt).getX();
            double Yp = this.liste_point.get(indice_pt).getY();
            P.setX(Xp);
            P.setY(Yp);
            this.liste_point.remove(P);
            Q.add(P);
        }
        ArrayList<Point> C = Q;
    }
    public int indice_PPV(Point P){
        double d = this.liste_point.get(0).distance(P);
        int indice_pt = 0;
        for (int i = 1 ; i < this.liste_point.size();i++){
            if (d > this.liste_point.get(i).distance(P)){
                d = this.liste_point.get(i).distance(P);
                indice_pt = i;
            }
        }
        return indice_pt;
    }
    public void iterative_2op(){
        boolean amelioration = true;
        while(amelioration == true ){
            amelioration = false;
            int j;
            for (int i = 0; i + 3 <this.liste_point.size();i++){
                j = i + 2;
                Point Pj = this.liste_point.get(j);
                Point Pj1 = this.liste_point.get(j+1);
                Point Pi = this.liste_point.get(i);
                Point Pi1 = this.liste_point.get(i+1);
                if( (Pi.distance(Pi1) + Pj.distance(Pj1)) > (Pi.distance(Pj) + Pi1.distance(Pj1))){
                    this.liste_point.set(i+1,Pj);
                    this.liste_point.set(j,Pi1);
                }
            }
        }
    }
    public void interchanger(int i,int j){
        Point P = this.liste_point.get(i);
        this.liste_point.remove(P);
        this.liste_point.add(j,P);
    }
}
