package pl.janek;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
                {
                    var frame = new ButtonFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);

                    Toolkit kit = Toolkit.getDefaultToolkit();
                    Dimension screenSize = kit.getScreenSize();
                    int screenWidth = screenSize.width;
                    int screenHeight = screenSize.height;
                    frame.setLocation(screenWidth / 4, screenHeight / 4);
                    frame.setSize(screenWidth / 2, screenHeight / 2);
                }
        );
    }
}
