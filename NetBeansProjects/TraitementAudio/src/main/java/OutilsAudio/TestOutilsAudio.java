/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OutilsAudio;

import javax.sound.sampled.AudioFormat;

/**
 *
 * @author guillaume.laurent
 */
public class TestOutilsAudio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        AudioFormat format = OutilsAudio.lireFormatFichierWAV("tada.wav");
        System.out.println(format);
        
        double[] echantillons = OutilsAudio.lireEchantillonsFichierWAV("tada.wav");
        OutilsAudio.jouer(echantillons, format.getSampleRate());

    }
    
}
