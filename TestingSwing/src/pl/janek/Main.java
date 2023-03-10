package pl.janek;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;


public class Main {

    public static void main(String[] args) {
        // Sprawdzanie czcionek w komputerze
//        String[] fontNames = GraphicsEnvironment
//                .getLocalGraphicsEnvironment()
//                .getAvailableFontFamilyNames();
//        for (String fontName: fontNames){
//            System.out.println(fontName);
//        }



        EventQueue.invokeLater(() ->
                {
                    var frame = new NotHelloWorldFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setTitle("Testing Swing GUI");

                    Toolkit kit = Toolkit.getDefaultToolkit();
                    Dimension screenSize = kit.getScreenSize();
                    int screenWidth = screenSize.width;
                    int screenHeight = screenSize.height;
                    frame.setLocation(screenWidth / 4, screenHeight / 4);
                    frame.setSize(screenWidth / 2, screenHeight / 2);

                    //Image img = new ImageIcon("icon.gif").getImage();
                    //frame.setIconImage(img);

                }
        );
    }
}

class NotHelloWorldFrame extends JFrame{
    public NotHelloWorldFrame()
    {

        add(new MyComponent());
        add(new MyComponent2());
        pack();
    }
}
class MyComponent extends JComponent {
    // lewy gorny od ktorego rysujemy
    public static final int MESSAGE_X = 400;
    public static final int MESSAGE_Y = 400;

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g) {
        var g2 = (Graphics2D) g;

        g2.setPaint(Color.MAGENTA);

        double leftX = 100;
        double leftY = 100;
        double width = 200;
        double height = 150;


        //prostokat
        var rect = new Rectangle2D.Double(leftX,leftY,width,height);
        g2.draw(rect);

        //elipsa
        var ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.fill(ellipse);

        // przekatna
        g2.draw(new Line2D.Double(leftX,leftY,leftX + width,leftY+ height));

        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = 150;

        var circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX,centerY,centerX+radius,centerY+radius);
        g2.draw(circle);

    }
    public Dimension getPrefferedSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
class MyComponent2 extends JComponent {
    // lewy gorny od ktorego rysujemy
    public static final int MESSAGE_X = 1600;
    public static final int MESSAGE_Y = 1600;

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g) {
        var g2 = (Graphics2D) g;

        g2.setPaint(Color.RED);
        var sansbold14 = new Font("SansSerif", Font.BOLD, 48);
        g2.setFont(sansbold14);
        var message = "Witaj, swiecie";
        g2.drawString(message,75,100);

    }
    public Dimension getPrefferedSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}