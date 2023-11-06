/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.tp;

/**
 *
 * @author user
 */
public class TestStocks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] code_barre = new int[10];
        Article article_1= new Article(code_barre, "CLE USB 8Go", 4.90, 200);
        Article article_2= new Article(code_barre, "CASQUE AUDIO", 56.00, 35);
        Article article_3= new Article(code_barre, "CABLE MICRO USB", 1.76, 8000);
        Stock Stock_1 = new Stock("Micromania");
        Stock_1.ajouter_un_article(article_1);
        Stock_1.ajouter_un_article(article_2);
        Stock_1.ajouter_un_article(article_3);
        System.out.println(Stock_1.toString());
        
    }
    
}
