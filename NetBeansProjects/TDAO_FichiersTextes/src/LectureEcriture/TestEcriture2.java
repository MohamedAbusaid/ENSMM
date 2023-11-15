package LectureEcriture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guillaume.laurent
 */
public class TestEcriture2 {

    /**
     * @param args the command line arguments 32 lignes
     */ 
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader fichier = new BufferedReader(new FileReader("poeme.txt"));
        String ligne;
        FileWriter fichier2 = new FileWriter ("poeme2.txt");
        for (int i = 0; i < 32; i++){
            ligne = fichier.readLine (); 
            fichier2.write(ligne.toUpperCase()+System.getProperty("line.separator"));
        }
        fichier2.close();

    }

}
