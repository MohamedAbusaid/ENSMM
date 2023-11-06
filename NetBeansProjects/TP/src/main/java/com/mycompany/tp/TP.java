/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tp;

/**
 *
 * @author user
 */
public class TP {


    public static void main(String[] args) {
        int[] code_barre = new int[10];
        Article t_shirt = new Article(code_barre,"Nike",3.2,5);
        Article même_t_shirt = new Article(code_barre,"Nike",3.2,5);
        Article t_shirt_plus_cher = new Article(code_barre,"Nike performance",4,5);
        System.out.println(t_shirt.equals(même_t_shirt));
        System.out.println(t_shirt.comparaison(t_shirt_plus_cher));
        System.out.println(t_shirt.equals(t_shirt_plus_cher));
        System.out.println(code_barre[0]);
    }
}
