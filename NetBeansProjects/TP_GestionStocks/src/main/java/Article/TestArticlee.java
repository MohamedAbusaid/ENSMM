/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Article;

/**
 *
 * @author user
 */
public class TestArticlee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] code_barre = new int[10];
        Article t_shirt = new Article(code_barre,"Nike",3.2,5);
        Article même_t_shirt = new Article(code_barre,"Nike",3.2,5);
        Article t_shirt_plus_cher = new Article(code_barre,"Nike",4,5);
        System.out.println(t_shirt.equals(même_t_shirt));
        System.out.println(t_shirt.compareto(t_shirt_plus_cher));
        
    }
}
