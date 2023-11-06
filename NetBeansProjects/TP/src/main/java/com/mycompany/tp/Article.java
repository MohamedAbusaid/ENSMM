/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp;

/**
 *
 * @author user
 */
public class Article {
    private int[] code_barre;
    private String designation;
    private double prix_unitaire;
    private int Quantite_en_stock;

    public Article(int[] code_barre, String designation, double prix_unitaire, int Quantite_en_stock) {
        this.code_barre = code_barre;
        this.designation = designation;
        this.prix_unitaire = prix_unitaire;
        this.Quantite_en_stock = Quantite_en_stock;
    }

    public int[] getCode_barre() {
        return code_barre;
    }

    public void setCode_barre(int[] code_barre) {
        this.code_barre = code_barre;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public int getQuantite_en_stock() {
        return Quantite_en_stock;
    }

    public void setQuantite_en_stock(int Quantite_en_stock) {
        this.Quantite_en_stock = Quantite_en_stock;
    }

    @Override
    public String toString() {
        return "Article{" + "code_barre=" + code_barre + ", designation=" + designation + ", prix_unitaire=" + prix_unitaire + ", Quantite_en_stock=" + Quantite_en_stock + '}';
    }
    
    
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Article other = (Article) obj;
        for (int i = 0; i < code_barre.length;i++){
            if (this.code_barre[i] != other.code_barre[i]) {
            return false;
            }
        }
        if (this.Quantite_en_stock != other.Quantite_en_stock) {
            return false;
        }
        if (this.designation!= other.designation) {
            return false;
        }
        if (this.prix_unitaire != other.prix_unitaire) {
            return false;
        }
        return true;
    }
    
    public String comparaison(Article article){
        if (this.prix_unitaire == article.prix_unitaire )
            return "le prix est le même";
        if (this.prix_unitaire > article.prix_unitaire )
            return "le prix de " + this.getDesignation() + " est supérieur";
        else {
            return "le prix de " + article.getDesignation() + " est supérieur";
        }
    }
    public boolean compareTo(Article article){
        if (this.prix_unitaire == article.prix_unitaire ){
            return true;
    }
        else {
            return false;
        }
    }
    
}

