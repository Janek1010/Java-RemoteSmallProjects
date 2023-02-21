package pl.janek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrame extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    public ButtonFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        buttonPanel = new JPanel();
        add(buttonPanel);
        makeButton("Zolty", Color.YELLOW);
        makeButton("Niebieski", Color.BLUE);
        makeButton("Czerwony", Color.red);
    }

    public void makeButton(String name, Color backgroundColor) {
        var button = new JButton(name);
        buttonPanel.add(button);
        button.addActionListener(event -> buttonPanel.setBackground(backgroundColor));
    }

}
