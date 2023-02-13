package pl.janek;

import jdk.jfr.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
                {
                    var frame =new FontFrame();
                    frame.setTitle("FontTest");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                }
        );
    }
}
class FontFrame extends JFrame
{
    public FontFrame()
    {
        add(new FontComponent());
        pack();
    }
}
class FontComponent extends JComponent
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g)
    {
        var g2 = (Graphics2D) g;
        var message = "Witaj swiecie!";

        var f = new Font("Serif", Font.BOLD, 36);
        g2.setFont(f);

        // Sprawdzenie rozmairu tekstu
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = f.getStringBounds(message, context);

        // set (x,y) = lewy gorny rog tesktu
        double x = (getWidth() - bounds.getWidth()) / 2;
        double y = (getHeight() - bounds.getHeight()) / 2;

        // Dodanie wydluzenia gornego do y w celu siegniecia linii bazowej
        double ascent = -bounds.getY();
        double baseY = y + ascent;

        //Rysowanie kontekstu
        g2.drawString(message,(int) x, (int) baseY);
        g2.setPaint(Color.LIGHT_GRAY);

        // Rysowanie linii bazowej
        g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));

        // Rysowanie otaczajacego tekstu prostokata
        var rect = new Rectangle2D.Double(x,y, bounds.getWidth(), bounds.getHeight());
        g2.draw(rect);
    }
    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

}
