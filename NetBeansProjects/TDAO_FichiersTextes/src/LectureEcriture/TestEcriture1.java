package LectureEcriture;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guillaume.laurent
 */
public class TestEcriture1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
//        BufferedReader fichier = new BufferedReader(new FileReader("poeme.txt"));
//        String ligne;
//        ligne = fichier.readLine (); 
//        System.out.println(ligne);
        FileWriter fichiern = new FileWriter ("fibonnacci.txt");
        int u = 1;
        int u1 = 1;
        ArrayList<Integer> L = new ArrayList<Integer>();
        L.add(u);
        L.add(u1);
        for (int i = 0; i < 50;i++){
            u1 = u + u1;
            L.add(u1);
            u = u1;
        }
        fichiern.write(L.toString());
        
        fichiern.close();
    }

}
