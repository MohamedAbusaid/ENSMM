package FenetreGraphique;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author guillaume.laurent
 */
public class TestFenetreGraphique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        FenetreGraphique fenetre = new FenetreGraphique("Hello World!", 300, 250);

        fenetre.getGraphics2D().setColor(Color.RED);
        fenetre.getGraphics2D().drawLine(10, 10, 60, 160);

        fenetre.getGraphics2D().setColor(Color.GREEN);
        fenetre.getGraphics2D().drawRect(100, 10, 50, 30);

        fenetre.getGraphics2D().setColor(Color.BLUE);
        fenetre.getGraphics2D().fillOval(200, 10, 20, 10);

        fenetre.getGraphics2D().drawString("Hello world!", 200, 50);

        fenetre.actualiser();

    }

}
