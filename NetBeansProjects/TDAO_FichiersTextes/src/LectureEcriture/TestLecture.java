package LectureEcriture;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
public class TestLecture {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        BufferedReader fichier = new BufferedReader(new FileReader("poeme.txt"));
        String ligne;
        ligne = fichier.readLine (); 
        System.out.println(ligne);

        
    }
    
}
