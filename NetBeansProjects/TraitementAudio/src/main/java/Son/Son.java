/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Son;

import OutilsAudio.OutilsAudio;
/**
 *
 * @author mabusaid
 */
public class Son {
    private double x[];
    private double frequence;
    private double tonalite;
    public Son(double fe,double duree){
        int l = (int) ( duree*fe);
        this.x = new double[l];
        for (int i = 0; i < l; i++){
            this.x[i] = 0.0;
        }
    }
    public Son(double fe,double duree, double amplitude,double fs){
        this.frequence = fe;
        this.tonalite = fs;
        this.x = new double[(int)(duree*fe)];
        for (int i=0 ; i < (int)(duree*fe) ;i++){
            this.x[i] = amplitude*Math.sin(2*Math.PI*(fs/fe));
        }
    }
    public double getF(){
        return this.frequence;
    }
    public double[] getX(){
        return this.x;
    }
    public int getDuree(){
        return this.x.length;
    }
    public void setF(double f){
        this.frequence = f;
    }
    public double valEff(){
        double xeff = 0;
        for (int i=0 ; i < this.x.length;i++){
            //System.out.println(xeff);
            xeff = xeff + Math.pow(this.x[i],2);
        }
        return   Math.sqrt(xeff/this.x.length);
    }
    public boolean constant(){
        int i = 1;
        double v = this.x[0];
        boolean reponse = true;
        while (i < this.x.length && reponse == true){
            if (this.x[i] == v){
                i = i + 1;
            }
            else{
                reponse = false;
            }
        }
        return reponse; 
    }
    public double cac(){
        double M = this.x[0];
        double m = this.x[0];
        for (int i=1 ; i < this.x.length;i++){
            
            if (this.x[i] > M){
                M =  this.x[i];
            }
            if (this.x[i] < m){
                m = this.x[i];
            }
        }

        return Math.abs(M - m);
    }
    public double[] getvals()
    {
    return this.x;
    }
    public String toString(){
        return "le signal de fréquence d'échantillonage " + this.frequence  + "de valeur éfficace " + this.valEff() +  " et de valeur crète à crète " + this.cac();
    }
    public Son(String nomDuFichier){
        this.x = OutilsAudio.lireEchantillonsFichierWAV(nomDuFichier);
        this.frequence =  OutilsAudio.lireFormatFichierWAV(nomDuFichier).getSampleRate();
    }
    public void jouerSon(){
        OutilsAudio.jouer(this.x, this.frequence);
        System.out.println(this.x.length);
    }
    public void amplification(int a){
        for (int i = 0; i < this.x.length;i++){
            this.x[i] = this.x[i]*a;
        }
    }
    public void echo(double r,double gain){
        double[] l = this.x;
        int i0 = 0;
        for (int k = 1; k < 3 ; k++){
        for (int i = (int)(r*this.frequence*k); i < this.x.length;i++){
            this.x[i] = this.x[i] + l[i0]*(gain/k);
            i0 = i0 + 1;
        }
        }
    }
}
   