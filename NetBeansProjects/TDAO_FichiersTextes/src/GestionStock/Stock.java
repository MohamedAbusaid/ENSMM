package GestionStock;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Classe modélisant un stock d'articles
 *
 * @author J.-M. Nicod
 */
public class Stock {

    private String societe;
    private ArrayList<Article> listeArticles;

    public Stock(String societe) {
        this.societe = societe;
        this.listeArticles = new ArrayList<Article>();
    }

    public String getSociete() {
        return this.societe;
    }

    public String toString() {
        String etatStock = "";
        for (int i = 0; i < this.listeArticles.size(); i++) {
            etatStock += this.listeArticles.get(i) + "\n";
        }
        return etatStock;
    }

    public void afficher() {
        System.out.println(this.societe);
        System.out.println(this);
    }

    public void ajouterArticle(Article a) {
        int index;
        index = this.listeArticles.indexOf(a);
        if (index < 0) {
            this.listeArticles.add(a);
        } else {
            this.listeArticles.get(index).augmenterStock(a.getQuantite());
        }
    }

    public void ajouterArticleALaGdPapa(Article a) {
        boolean trouve = false;
        int index = 0;
        while ((trouve == false) && (index < this.listeArticles.size())) {
            if (this.listeArticles.get(index).equals(a)) {
                trouve = true;
            } else {
                index++;
            }
        }
        if (trouve == true) {
            this.listeArticles.get(index).augmenterStock(a.getQuantite());
        } else {
            this.listeArticles.add(a);
        }
    }

    public double getValeurStock() {
        double valeur = 0.0;
        for (int i = 0; i < this.listeArticles.size(); i++) {
            valeur += this.listeArticles.get(i).getValeurStock();
        }
        return valeur;
    }

    public boolean estValide(Stock panier) {
        boolean panierValide = true;
        int indexStock;
        int indexPanier = 0;
        while ((panierValide == true)
                && (indexPanier < panier.listeArticles.size())) {
            indexStock = this.listeArticles.indexOf(panier.listeArticles.get(indexPanier));
            if (indexStock < 0) {
                panierValide = false;
            } else {
                if (this.listeArticles.get(indexStock).getQuantite()
                        < panier.listeArticles.get(indexPanier).getQuantite()) {
                    panierValide = false;
                } else {
                    indexPanier++;
                }
            }
        }
        return panierValide;
    }

    public void validerPanier(Stock panier) {
        int indexStock;
        int quantiteArticlePanier;
        Article articlePanier;
        if (this.estValide(panier)) {
            for (int i = 0; i < panier.listeArticles.size(); i++) {
                articlePanier = panier.listeArticles.get(i);
                quantiteArticlePanier = articlePanier.getQuantite();
                indexStock = this.listeArticles.indexOf(articlePanier);
                this.listeArticles.get(indexStock).diminuerStock(quantiteArticlePanier);
            }
        }
    }

    public Stock articlesACommander() {
        Stock reassort = new Stock("réassort");
        Article articleCourant;
        Article articleACommander;
        for (int i = 0; i < this.listeArticles.size(); i++) {
            articleCourant = this.listeArticles.get(i);
            if (articleCourant.getQuantite() <= 2) {
                articleACommander = articleCourant.copie();
                articleACommander.augmenterStock(10);
                reassort.ajouterArticle(articleACommander);
            }
        }
        return reassort;
    }
    
    public void ajouterStock(Stock reception){
        for (int i=0;i<reception.listeArticles.size();i++){
            this.ajouterArticle(reception.listeArticles.get(i));
        }
    }
    public void lireFichier(String NomFichier) throws FileNotFoundException, IOException{
        BufferedReader fichier = new BufferedReader(new FileReader(NomFichier));
        String ligne;
        ligne = fichier.readLine();
        
        while (fichier.ready()){
            ligne = fichier.readLine();
            String tabligne[] = ligne.split(";");
            double prixUnitaire = Double.parseDouble(tabligne[3].replace(",","."));
            int quantite = Integer.parseInt(tabligne[2]);
            Article a = new Article(tabligne[1],tabligne[0],prixUnitaire,quantite);
            this.ajouterArticleALaGdPapa(a);
        }
    }
        public void ecrireFichier(String nomDuFichier) throws IOException{
            FileWriter fichier = new FileWriter(nomDuFichier);
            fichier.write(this.societe + System.getProperty("line.separator"));
            fichier.write("Designation;Code barre;Quantite;Prix Unitaire" + System.getProperty("line.separator"));
            for (int i = 0; i < this.listeArticles.size();i++){
                fichier.write(this.listeArticles.get(i).toString() + System.getProperty("line.separator"));
            }
            fichier.close();
        }
    }
