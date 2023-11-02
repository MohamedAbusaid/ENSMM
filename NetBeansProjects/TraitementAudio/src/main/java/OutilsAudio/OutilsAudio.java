/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OutilsAudio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author guillaume.laurent
 */
public class OutilsAudio {
       
     public static AudioInputStream convertirEnAudioInputStream(double[] echantillons, double frequenceEchantillonnage) {
         
        short[] shortArr = new short[echantillons.length]; 
        for (int i = 0; i < echantillons.length; i++) {
            shortArr[i] = (short)(echantillons[i] * 0x8000);
        } 
         
        byte[] byteArr = new byte[echantillons.length * 2];
        ByteBuffer.wrap(byteArr).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(shortArr);

        return new AudioInputStream(new ByteArrayInputStream(byteArr),
                new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, (float)frequenceEchantillonnage, 16, 1, 2, (float)frequenceEchantillonnage, false),
                byteArr.length);
    }

    public static void jouer(double[] echantillons, double frequenceEchantillonnage) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(convertirEnAudioInputStream(echantillons, frequenceEchantillonnage));
            clip.start();
            clip.drain();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (LineUnavailableException | InterruptedException | IOException ex) {
            Logger.getLogger(OutilsAudio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static double[] lireEchantillonsFichierWAV(String nomDuFichier) {
        byte[] byteArr = new byte[0];
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            AudioInputStream stream = AudioSystem.getAudioInputStream(new File(nomDuFichier));
            
            if (stream.getFormat().getChannels()!=1) {
                throw new UnsupportedAudioFileException("Le fichier audio ne doit comporter qu'un seul canal.");
            } 
            if (stream.getFormat().getEncoding()!=AudioFormat.Encoding.PCM_SIGNED || stream.getFormat().getSampleSizeInBits()!=16 || stream.getFormat().getFrameSize()!=2 || stream.getFormat().isBigEndian()) {
                throw new UnsupportedAudioFileException("Le fichier audio doit être encodé en PCM_SIGNED, 16 bits, mono, 2 bytes/frame, little-endian.");
            } 
                      
            int numOfBytes;
            byte[] buffer = new byte[1024];

            while ((numOfBytes = stream.read(buffer)) > 0) {
                out.write(buffer, 0, numOfBytes);
            }
            out.flush();
            byteArr = out.toByteArray();
        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(OutilsAudio.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        short[] shortArr = new short[byteArr.length/2]; // new a supprimer !!!
        ByteBuffer.wrap(byteArr).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(shortArr);

        double[] echantillons = new double[shortArr.length];
        for (int i = 0; i < echantillons.length; i++) {
            echantillons[i] = ((double)shortArr[i])/0x8000;
        }
        
        return echantillons;
    }

    public static AudioFormat lireFormatFichierWAV(String nomDuFichier) {
        AudioInputStream stream = null;
         try {
             stream = AudioSystem.getAudioInputStream(new File(nomDuFichier));
         } catch (UnsupportedAudioFileException | IOException ex) {
             Logger.getLogger(OutilsAudio.class.getName()).log(Level.SEVERE, null, ex);
         } 
        return stream.getFormat();
    }

    public static void ecrireFichierWAV(String nomDuFichier,double[] echantillons, double frequenceEchantillonnage) {
        try {
            AudioSystem.write(convertirEnAudioInputStream(echantillons, frequenceEchantillonnage), AudioFileFormat.Type.WAVE, new File(nomDuFichier));
        } catch (IOException ex) {
            Logger.getLogger(OutilsAudio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
