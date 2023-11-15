/*
 * To change this license header, choose License Headers in Project 
/*Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReleveMeteo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author guillaume.laurent
 */
public class TestReleveMeteo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        // TODO code application logic here
//        
//        ReleveMeteo releve = new ReleveMeteo("Besançon", 2015);
//        double temperatureDonnee;
//        temperatureDonnee= 20.0;
//        
//        releve.setTemperature(1, 2.0);
//        releve.setTemperature(3, -1.3);
//        releve.setTemperature(4, -3.0);
//        releve.setTemperature(10, -1.0);
//        releve.setTemperature(12, -3.0);
//        releve.setTemperature(13, -4.0);
//        releve.setTemperature(14, -3.0);
//        releve.setTemperature(18, 10);
//        releve.setTemperature(19, 10);
//        releve.setTemperature(30, -1.3);
//              
//        System.out.println(releve);
//        
//        System.out.println("Temperature moyenne = " + releve.getTemperatureMoyenne());
//        System.out.println("Nombre de jours de gel = " + releve.getNombreDeJoursDeGel());
//        System.out.println("Au moins un jour de gel = " + releve.contientUnJourDeGel());
//        System.out.println("Temperature minimale = " 
//                + releve.getTemperatureMinimale());
//        System.out.println("Temperature > TemperatureDonnée = " 
//                + releve.contientTemperatureSuperieureA(temperatureDonnee));        
//        System.out.println("Nb périodes sous 0 = " 
//                + releve.getNombrePeriodesInferieureA(0.0));
//        
//        System.out.println("Taille plus grande période sous 0 = " 
//                + releve.dureePlusGrandePeriodesInferieureA(0.0) );
//        
//        System.out.println("HISTOGRAMME DES TEMPERATURES...");
//        int [][] histo;
//        histo = releve.histogrammeTemperature();
//        for (int i = 0; i < histo[0].length; i++) {
//            System.out.print("(" + histo[0][i]
//                    + "," + histo[1][i] + ") ");
//        }
//        System.out.println();
        ReleveMeteo r = new ReleveMeteo("Test",1999);
        r.lireFichier("releve.txt");
        System.out.print(r);
        r.Graphique("releve.txt");
    }
    
    
}