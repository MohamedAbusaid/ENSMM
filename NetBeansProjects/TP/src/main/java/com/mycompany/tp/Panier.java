/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Panier {
    private String nom_client;
    private ArrayList<Article> liste_articles;
    public Panier(String Nom){
        this.nom_client = Nom;
        this.liste_articles = new ArrayList<Article>();
    }
    public void ajouter_article(Article article){
        boolean presence = false;
        int indice_article_similaire = 0;
        for (int i = 0 ; i < this.liste_articles.size() ; i ++){
            if (this.liste_articles.equals(article)){
                presence = true;
                indice_article_similaire = i;
            }
        }
        if (presence == true){ 
            this.liste_articles.get(indice_article_similaire).setQuantite_en_stock(this.liste_articles.get(indice_article_similaire).getQuantite_en_stock()+article.getQuantite_en_stock());
        }
        else {
            this.liste_articles.add(article);
        }
    }
    public String toString(){
        return "Le client : " + this.nom_client + " a les articles suivant dans son panier : " + this.toString_liste_articles();
    }
    private String toString_liste_articles(){
        String L = "";
        for (int i = 0 ; i < this.liste_articles.size() ; i++){
            L = L + this.liste_articles.get(i).getDesignation();
            if (i < this.liste_articles.size()-1){
                L = L + " // ";
            }
        }
        return L;
    }
    public double prix_panier(){
        double prix_tot = 0;
        for (int i = 0 ; i < this.liste_articles.size() ; i++){
            prix_tot = prix_tot + this.liste_articles.get(i).getPrix_unitaire();
        }
        return prix_tot;
    }
    public double prix_panier_30(){
        double prix_tot = 0;
        int ind_art_cher = 0;
        double prix_max = this.liste_articles.get(0).getPrix_unitaire();
        for (int i = 1 ; i < this.liste_articles.size() ; i++){
            if (this.liste_articles.get(i).getPrix_unitaire() > prix_max ){
                prix_max = this.liste_articles.get(i).getPrix_unitaire();
                ind_art_cher = i;
            }
        }
        for (int i = 0 ; i < this.liste_articles.size() ; i++){
            if (i == ind_art_cher){
                 prix_tot = prix_tot + this.liste_articles.get(i).getPrix_unitaire()*0.7;
            }
            else {
                prix_tot = prix_tot + this.liste_articles.get(i).getPrix_unitaire();
            }
        }
        return prix_tot;
    }
        public void copie_panier(Panier panier){
            for (int i = 0 ; i < this.liste_articles.size() ; i++){
                this.ajouter_article(panier.liste_articles.get(i));
        }
    }
}
