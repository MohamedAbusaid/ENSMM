package FenetreGraphique;

import java.awt.Color;
import java.awt.Font;

public class TestFenetreGraphique {

    public static void main(String[] args) {
        FenetreGraphique fenetre = new FenetreGraphique("Hello World!", 300, 200);

        fenetre.getGraphics2D().setColor(Color.RED);
        fenetre.getGraphics2D().drawLine(10, 50, 150, 150);

        fenetre.getGraphics2D().setColor(Color.GREEN);
        fenetre.getGraphics2D().drawRect(100, 50, 40, 10);

        fenetre.getGraphics2D().setColor(Color.BLUE);
        fenetre.getGraphics2D().fillOval(150, 100, 20, 10);

        fenetre.getGraphics2D().drawString("Hello world!", 200, 50);
        fenetre.repaint();
    }
}
