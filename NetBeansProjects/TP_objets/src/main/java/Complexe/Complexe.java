/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Complexe;

/**
 *
 * @author user
 */

public class Complexe {

    /**
     * partie réelle du complexe this (visibilité privée)
     */
    private double partieReelle;
    /**
     * partie imaginaire du complexe this (visibilité privée)
     */
    private double partieImaginaire;

    /**
     * constructeur qui construit re + im.i
     *
     * @param re la partie réelle du complexe this
     * @param im la partie imaginaire du complexe this
     */
    public Complexe(double re, double im) {
        this.partieReelle = re;
        this.partieImaginaire = im;
    }

    /**
     * Constructeur qui construit le complexe re
     *
     * @param re la partie réelle du complexe this
     */
    public Complexe(double re) {
        this(re, 0);
    }

    /**
     * Constructeur par défaut qui construit le complexe 0
     */
    public Complexe() {
        this(0);
    }

    /**
     * accesseur en consultation de la partie réelle de this
     *
     * @return la partie réelle de this
     */
    public double getPartieReelle() {
        return this.partieReelle;
    }

    /**
     * accesseur en consultation de la partie imaginaire de this
     *
     * @return la partie imaginaire de this
     */
    public double getPartieImaginaire() {
        return this.partieImaginaire;
    }

    /**
     * modificateur de la partie réelle de this
     *
     * @param re la nouvelle partie réelle de this
     */
    public void setPartieReelle(double re) {
        this.partieReelle = re;
    }

    /**
     * modificateur de la partie imaginaire de this
     *
     * @param im la nouvelle partie imaginaire de this
     */
    public void setPartieImaginaire(double im) {
        this.partieImaginaire = im;
    }

    /**
     * retourne le module de this
     *
     * @return le module de this
     */
    public double module() {
        return Math.sqrt(this.partieReelle * this.partieReelle + this.partieImaginaire * this.partieImaginaire);
    }

    /**
     * retourne le complexe conjugué de this
     *
     * @return le complexe conjugué de this
     */
    public Complexe conjugue() {
        return new Complexe(this.partieReelle, -this.partieImaginaire);
    }

    /**
     * retourne la somme de this avec le complexe unComplexe
     *
     * @param unComplexe complexe second membre de l'addition
     * @return la somme de this avec le complexe unComplexe
     */
    public Complexe plus(Complexe unComplexe) {
        return new Complexe(this.partieReelle + unComplexe.partieReelle,
                this.partieImaginaire + unComplexe.partieImaginaire);
    }

    /**
     * retourne la différence de this avec le complexe unComplexe
     *
     * @param unComplexe complexe second membre de la soustraction
     * @return la différence de this avec le complexe unComplexe
     */
    public Complexe moins(Complexe unComplexe) {
        return new Complexe(this.partieReelle - unComplexe.partieReelle,
                this.partieImaginaire - unComplexe.partieImaginaire);
    }

    /**
     * retourne la multiplication de this avec le complexe unComplexe
     *
     * @param unComplexe complexe second membre de la multiplication
     * @return la multiplication de this avec le complexe unComplexe
     */
    public Complexe fois(Complexe unComplexe) {
        return new Complexe(this.partieReelle * unComplexe.partieReelle - this.partieImaginaire * unComplexe.partieImaginaire,
                this.partieReelle * unComplexe.partieImaginaire + this.partieImaginaire * unComplexe.partieReelle);
    }

    /**
     * retourne la division de this avec le complexe unComplexe
     *
     * @param unComplexe complexe second membre de la division
     * @return la division de this avec le complexe unComplexe
     */
    public Complexe diviserPar(Complexe unComplexe) {
        double unModule = unComplexe.module();
        double leCarreDuModule = unModule * unModule;
        double partieReelle = (this.partieReelle * unComplexe.partieReelle
                + this.partieImaginaire * unComplexe.partieImaginaire) / leCarreDuModule;
        double partieImaginaire = (this.partieImaginaire * unComplexe.partieReelle
                - this.partieReelle * unComplexe.partieImaginaire) / leCarreDuModule;
        return new Complexe(partieReelle, partieImaginaire);
    }

    /**
     * egalité entre this et un autre complexe
     *
     * @param obj complexe dont on teste l'égalité avec this
     * @return true si egalité entre this et unComplexe
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Complexe other = (Complexe) obj;
        if (Double.doubleToLongBits(this.partieReelle) != Double.doubleToLongBits(other.partieReelle)) {
            return false;
        }
        if (Double.doubleToLongBits(this.partieImaginaire) != Double.doubleToLongBits(other.partieImaginaire)) {
            return false;
        }
        return true;
    }

    /**
     * conversion du complexe this en chaine de caractères
     */
    public String toString() {
        if (this.partieImaginaire == 0) {
            return this.partieReelle + "";
        } else if (this.partieImaginaire > 0) {
            return this.partieReelle + "+" + this.partieImaginaire + "i";
        } else {
            return "" + this.partieReelle + " " + this.partieImaginaire + "i";
        }
    }

    /**
     * affichage du complexe this dans la console
     */
    public void afficher() {
        System.out.println(this.toString());
    }
    
    /**
     * retourne une copie du complexe this
     */
    public Complexe clone() {
        return new Complexe(this.partieReelle, this.partieImaginaire);
    }

}
