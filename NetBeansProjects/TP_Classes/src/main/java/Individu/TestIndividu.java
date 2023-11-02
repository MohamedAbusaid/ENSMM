/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Individu;

/**
 *
 * @author user
 */
public class TestIndividu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Individu Moi;
        Moi = new Individu("Abusaid","Mohamed",100,180,2002,"M");
        System.out.println(Moi.toString());
        System.out.println(Moi.getTaille());
        Moi.setTaille(181);
        System.out.println(Moi.getTaille());
        
    }
    
}
