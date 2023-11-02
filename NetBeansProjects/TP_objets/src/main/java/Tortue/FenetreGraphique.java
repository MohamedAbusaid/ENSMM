package Tortue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe de dessin 2D
 *
 * @author guillaume.laurent
 */
public class FenetreGraphique extends JFrame {

    private JPanelImage panel;


    public FenetreGraphique(String titre, int largeur, int hauteur, int posX, int posY) {
        super();
        panel = new JPanelImage(largeur, hauteur);
        getContentPane().add(panel);
        setTitle(titre);
        this.setLocation(posX, posY);
        setSize(largeur, hauteur);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public FenetreGraphique(String titre, int largeur, int hauteur) {
        this(titre, largeur, hauteur, 0, 0) ;
    }

    public Graphics2D getGraphics2D() {
        return panel.getGraphics2D();
    }

    public JPanelImage getJPanel() {
        return panel;
    }

    
    public void fermer() {
        dispose();
    }
    
    
    class JPanelImage extends JPanel {

        private BufferedImage image;
        private Graphics2D graphics;

        public JPanelImage(int width, int height) {
            super();
            setSize(width, height);
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);//, BufferedImage.TYPE_INT_RGB);
            graphics = image.createGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);

            RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            rh.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            graphics.setRenderingHints(rh);

        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }

        public Graphics2D getGraphics2D() {
            return graphics;
        }

    }
}
