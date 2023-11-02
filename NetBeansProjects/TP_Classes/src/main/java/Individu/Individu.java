/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Individu;


/**
 *
 * @author mabusaid
 */


public class Individu {
    // attributs
    
    private String nom;
    private String prenom;
    private double poids;
    private int dateN;
    private int taille;
    private String sexe;
    // constructeurs
    public Individu(String nom, String prenom,  int poids, int taille,  int dateN, String sexe){
        this.nom = nom;
        this.prenom = prenom;
        this.poids = poids;
        this.dateN = dateN;
        this.taille = taille;
        this.sexe = sexe;
    }
    public Individu(){
        this("Nom","Prenom",100,180,9999,"M");
    }
    public int getTaille(){
        return this.taille;
    }
    public void setTaille(int T){
        this.taille = T;
    }
    public String toString(){
        return this.nom+" "+this.prenom+" ne en "+this.dateN+" pesant "+this.poids+"kg et mesurant "+this.taille+"cm de sexe "+this.sexe;      
    }
    public void majForce(){
        this.nom = this.nom.toUpperCase();
    }
    public double calculIMC(){
        return this.poids/(this.taille*this.taille);
    }
    public String corpNormale(){
        if ((this.calculIMC()>18.5)&&(this.calculIMC()<25)){
            return "IMC Normale";
        }
        if (this.calculIMC()<18.5){
            return "IMC inférieure à la normale";
        }
        else {
            return "IMC supérieure à la normale";
        }
    }
    public String genEMAIL(){
        return this.nom+"."+this.prenom+"@ens2m.org";
    }
    public boolean equals(Individu obj){
        if ((this.prenom == obj.prenom)&&(this.nom == obj.nom)){
            if (this.dateN == obj.dateN){
                return true;
            }
        }
        if (obj == null){
            return false;
        }
        return false;
    }
}

