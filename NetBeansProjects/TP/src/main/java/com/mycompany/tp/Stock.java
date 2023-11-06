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
public class Stock {
    private ArrayList<Article> liste_articles;
    private String nom_societe;
    

    public Stock(String Nom) {
        this.liste_articles = new ArrayList<Article>();
        this.nom_societe = Nom;
    }
    public void ajouter_un_article(Article article){
        this.liste_articles.add(article);
    }
    private String toString_articles(){
        String L = " ";
        for (int i = 0 ; i < liste_articles.size() ; i++){
            L = L + liste_articles.get(i).getDesignation();
            if (i < liste_articles.size()-1){
                L = L + " //  " ;
            }
        }
        return L;
    }
    public String toString(){
        return "La societe : "+this.nom_societe+" dispose des articles suivant en stock : " + this.toString_articles();
    }
    public int getQtt_en_stock(String designation){
        boolean presence = false;
        int ind_article = 0;
        int i = 0 ;
        while (presence == false && i < this.liste_articles.size()){
            if (this.liste_articles.get(i).getDesignation() == designation){
                presence = true;
                ind_article = i;
            }
            i++;
        }
        return this.liste_articles.get(ind_article).getQuantite_en_stock();
    }
    /*
    public void sort(){
        this.liste_articles = this.liste_articles.sort(this.liste_articles.get(0));
    }
    */
}
