/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clavier;

/**
 *
 * @author guillaume.laurent
 */
public class TestClavier {

    public static void main(String[] args) {
        
        System.out.println("Veuillez entrer un entier : ");
        int unEntier = Clavier.getInt();
        System.out.println("Vous avez entre : " + unEntier);
        
        System.out.println("Veuillez entrer un reel : ");
        double unReel = Clavier.getDouble();
        System.out.println("Vous avez entre : " + unReel);
        
        System.out.println("Veuillez entrer un booleen : ");
        boolean unBooleen = Clavier.getBoolean();
        System.out.println("Vous avez entre : " + unBooleen);
        
    }
    
}