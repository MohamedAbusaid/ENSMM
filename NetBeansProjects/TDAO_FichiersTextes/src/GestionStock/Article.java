package GestionStock;

/**
 * Classe modélisant un article
 *
 * @author C. Varnier, J.-M. Nicod
 */
public class Article {

    // attributs de la classe Article
    private String codeBarre;
    private String designation;
    private double prixUnitaire;
    private int quantite;

    // constructeurs de la classe Article
    public Article(String cb, String design, double pu, int quantite) {
        this.codeBarre = cb;
        this.designation = design;
        this.prixUnitaire = pu;
        this.quantite = quantite;
    }

    public Article() {
        this("1111111111111", "article sans nom", 0.0, 0);
    }

    // méthodes de la classe Article
    public String getDesignation() {
        return this.designation;
    }

    public void augmenterStock(int nbUnite) {
        this.quantite = this.quantite + nbUnite;
    }

    /** Opération inverse de l'ajout d'un nb d'unités de l'article courant
     * avec retour de la quantité non prévelée si le stock est trop faible
     */
    public int diminuerStock(int nbUnite) {
        int reste = 0;
        if (nbUnite > this.quantite) {
            reste = nbUnite - this.quantite;
            this.quantite = 0;
        } else {
            this.quantite = this.quantite - nbUnite;
        }
        return reste;
    }

    public void setPrixUnitaire(double nouveauPU) {
        this.prixUnitaire = nouveauPU;
    }

    public double getValeurStock() {
        return this.prixUnitaire * this.quantite;
    }

    public int getQuantite() {
        return this.quantite;
    }

    public boolean estCritique() {
        return this.quantite <= 10;
    }

    public String toString() {
        return this.designation + ";" + this.codeBarre  + ";" + this.quantite +";" + this.prixUnitaire;
    }

    public boolean equals(Object obj) {
        // si les objets sont de même classe
        if (obj.getClass().equals(this.getClass())) {
            // convertit obj en Article
            Article art = (Article) obj;
            if (this.codeBarre.equals(art.codeBarre)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public int compareTo(Object obj) {
        Article art = (Article) obj;
        if (this.getValeurStock() < art.getValeurStock()) {
            return -1;
        } else if (this.getValeurStock() > art.getValeurStock()) {
            return 1;
        } else {
            return 0;
        }
    }

     public Article copie() {
        return  new Article(this.codeBarre, this.designation, this.prixUnitaire, this.quantite);
    }
    

}
