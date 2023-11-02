/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Complexe;


/**
 * Classe pour le test de la classe Complexe
 */
public class TestComplexe2 {

    public static void main(String[] args) {

        Complexe a = new Complexe(1.0, 2.0);
        Complexe b = new Complexe(1.0, 2.0);

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("(a==b) est " + (a == b));
        System.out.println("a.equals(b) est " + a.equals(b));
        System.out.println("-------------------------------");

        Complexe c = a;
        c.setPartieReelle(0);
        System.out.println("a = " + a);
        System.out.println("c = " + c);
        System.out.println("(a==c) est " + (a == c));
        System.out.println("a.equals(c) est " + a.equals(c));
        System.out.println("-------------------------------");

        Complexe d = b.clone();
        d.setPartieReelle(0);
        System.out.println("b = " + b);
        System.out.println("d = " + d);
        System.out.println("(b==d) est " + (b == d));
        System.out.println("b.equals(d) est " + b.equals(d));
        System.out.println("-------------------------------");

    }
}

