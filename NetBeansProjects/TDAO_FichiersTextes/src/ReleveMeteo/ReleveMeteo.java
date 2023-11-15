package ReleveMeteo;

import FenetreGraphique.FenetreGraphique;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author G. Laurent, J.-M. Nicod
 */
public class ReleveMeteo {

    private String ville;
    private int annee;
    private double temperature[];

    public ReleveMeteo(String ville, int annee) {
        this.ville = ville;
        this.annee = annee;
        this.temperature = new double[365];
        for (int i = 0; i < this.temperature.length; i++) {
            this.temperature[i] = 0.0;
        }
    }

    public double getTemperature(int jour) {
        return this.temperature[jour - 1];
    }

    public void setTemperature(int jour, double temperature) {
        this.temperature[jour - 1] = temperature;
    }

    public double getTemperatureMoyenne() {
        double somme = 0;
        for (int i = 0; i < this.temperature.length; i++) {
            somme = somme + this.temperature[i];
        }
        return somme / this.temperature.length;
    }

    public boolean estPlusChaudEnMoyenneQue(ReleveMeteo autre) {
        if (this.getTemperatureMoyenne() > autre.getTemperatureMoyenne()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean contientUnJourDeGel() {
        boolean jourDeGel = false;
        int i = 0;
        while (i < this.temperature.length && jourDeGel == false) {
            if (this.temperature[i] < 0.0) {
                jourDeGel = true;
            } else {
                i = i + 1;
            }
        }
        return jourDeGel;
    }

    public boolean contientTemperatureSuperieureA(double temperature) {
        int i = 0;
        boolean supValeur = false;
        while ((i < this.temperature.length) && (supValeur == false)) {
            if (this.temperature[i] > temperature) {
                supValeur = true;
            } else {
                i = i + 1;
            }
        }
        return supValeur;
    }

    public boolean contientTemperatureInferieureA(double temperature) {
        boolean temperatureBasse = false;
        int i = 0;
        while (i < this.temperature.length && !temperatureBasse) {
            if (this.temperature[i] < temperature) {
                temperatureBasse = true;
            } else {
                i = i + 1;
            }
        }
        return temperatureBasse;
    }

    
    public int getNombreDeJoursDeGel() {
        int nombreDeJourDeGel = 0;
        for (int i = 0; i < this.temperature.length; i++) {
            if (this.temperature[i] < 0.0) {
                nombreDeJourDeGel = nombreDeJourDeGel + 1;
            }
        }
        return nombreDeJourDeGel;
    }

    public int getNombreJoursInferieursA(double temperature) {
        int nbJourSousT = 0;
        for (int i = 0; i < this.temperature.length; i++) {
            if (this.temperature[i] < temperature) {
                nbJourSousT = nbJourSousT + 1;
            }
        }
        return nbJourSousT;
    }
    
    public int getNombrePeriodesInferieureA(double temperature) {
        int nbPeriodesSousT = 0;
        boolean dansUnePeriode = false;
        for (int i = 0; i < this.temperature.length; i++) {
            if (this.temperature[i] < temperature) {
                if (!dansUnePeriode) {
                    dansUnePeriode = true;
                    nbPeriodesSousT = nbPeriodesSousT + 1;
                }
            } else if (dansUnePeriode) {
                dansUnePeriode = false;
            }
        }
        return nbPeriodesSousT;
    }
    
    public double getTemperatureMinimale() {
        double temperatureMin = this.temperature[0];
        for (int i = 1; i < this.temperature.length; i++) {
            if (this.temperature[i] < temperatureMin) {
                temperatureMin = this.temperature[i];
            }
        }
        return temperatureMin;
    }

    public double getTemperatureMaximale() {
        double temperatureMax = this.temperature[0];
        for (int i = 1; i < this.temperature.length; i++) {
            if (this.temperature[i] > temperatureMax) {
                temperatureMax = this.temperature[i];
            }
        }
        return temperatureMax;
    }


    public String toString() {
        String affichage = "ville=" + ville + ", annee=" + annee + ", "
                + "temperature={";
        for (int i = 0; i < this.temperature.length; i++) {
            affichage = affichage + this.temperature[i] + ";";
        }
        affichage = affichage + "}";
        return affichage;
    }

    public int dureePlusGrandePeriodesInferieureA(double temperature) {
        int nbJoursDansLaPeriode = 0;
        int dureePlusGrandePeriode = 0;
        boolean dansUnePeriode = false;
        for (int i = 0; i < this.temperature.length; i++) {
            if (this.temperature[i] < temperature) {
                if (!dansUnePeriode) {
                    dansUnePeriode = true;
                    nbJoursDansLaPeriode = 1;
                } else {
                    nbJoursDansLaPeriode++;
                }
            } else if (dansUnePeriode) {
                dansUnePeriode = false;
                if (dureePlusGrandePeriode < nbJoursDansLaPeriode) {
                    dureePlusGrandePeriode = nbJoursDansLaPeriode;
                }
            }
        }
        return dureePlusGrandePeriode;
    }

    /** Histogramme a 2 colonnes, la premiere avec la temperature et la seconde 
     * avec le nombre d'occurrence de la température correspondante.
     */
    public int[][] histogrammeTemperature() {
        int[][] histoTemperature;
        int tempMini = (int) Math.floor(this.getTemperatureMinimale());
        int tempMaxi = (int) Math.floor(this.getTemperatureMaximale());

        histoTemperature = new int[2][tempMaxi - tempMini + 1];

        for (int i = 0; i < histoTemperature[0].length; i++) {
            histoTemperature[0][i] = tempMini + i;
            histoTemperature[1][i] = 0;
        }

        int indiceHisto;
        for (int i = 0; i < this.temperature.length; i++) {
            indiceHisto = (int) Math.floor(this.temperature[i]) - tempMini;
            histoTemperature[1][indiceHisto] = 1 + histoTemperature[1][indiceHisto];
        }
        return histoTemperature;
    }
    public void lireFichier(String NomFichier) throws FileNotFoundException, IOException{
        BufferedReader fichier = new BufferedReader(new FileReader(NomFichier));
        String ligne;
        ligne = fichier.readLine();
        ligne = fichier.readLine();
        String tabligne1[] = ligne.split(" : ");
        String Ville = tabligne1[1];
        ligne = fichier.readLine();
        String tabligne2[] = ligne.split(" : ");
        int Annee = Integer.parseInt(tabligne2[1]);
        this.annee = Annee;
        this.ville = Ville;
        int i = 0;
        while (ligne.startsWith("#")){
            ligne = fichier.readLine();
        }
        String tempm;
        while (fichier.ready()){
            ligne = ligne.substring(30, 38);
            this.temperature[i] = Double.parseDouble(ligne);
            System.out.println(this.temperature[i]);
            ligne = fichier.readLine();
            i++;
        }
    }
    public void Graphique(String nomFichier) throws IOException{
        this.lireFichier(nomFichier);
        FenetreGraphique fenetre = new FenetreGraphique(nomFichier,1500,1000);
        fenetre.getGraphics2D().setColor(Color.RED);
        System.out.println(this.toString());
        for (int i = 0; i < this.temperature.length-1;i++){
            fenetre.getGraphics2D().drawLine(i*4, (int)this.temperature[i]*10+100, (i+1)*4, (int)temperature[i+1]*10+100);
        }
        fenetre.repaint();
    }
}
