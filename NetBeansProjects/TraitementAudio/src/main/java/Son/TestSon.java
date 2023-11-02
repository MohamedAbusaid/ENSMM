/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Son;

import OutilsAudio.OutilsAudio;

/**
 *
 * @author mabusaid
 */
public class TestSon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Son Son440 = new Son(1000,60,1.0,440);
        System.out.println(Son440.toString() );
        Son Sonfichier = new Son("e-ho.wav");
        
        
        Sonfichier.echo(0.2, 0.7);
        Sonfichier.jouerSon();
    }
    
    
}
