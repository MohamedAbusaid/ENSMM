/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionStock;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author nicod
 */
public class TestStock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
       Stock s = new Stock("ENSMM");
       s.lireFichier("stock.csv");
       s.afficher();
       s.ecrireFichier("Copie_Stock.csv");
       Stock reap = s.articlesACommander();
       reap.ecrireFichier("reaprovisionnement.csv");
    }

}
