package pl.janek;

import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import java.util.prefs.*;
import javax.swing.*;

/**
 * Program testuj�cy ustawienia preferencji. Zapami�tuje
 * po�o�enie i rozmiar ramki oraz ostatnio otwarty plik.
 * @version 1.10 2018-04-10
 * @author Cay Horstmann
 */
public class ImageViewer
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            var frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * Przegl�darka plik�w, kt�ra przywraca ustawienia pozycji, rozmiaru i obrazu
 * z preferencji u�ytkownika oraz aktualizuje preferencje przy zamykaniu programu.
 */
class ImageViewerFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private String image;

    public ImageViewerFrame()
    {
        Preferences root = Preferences.userRoot();
        Preferences node = root.node("/com/horstmann/corejava/ImageViewer");
        // pobranie pozycji, rozmiaru i tytu�u z preferencji
        int left = node.getInt("left", 0);
        int top = node.getInt("top", 0);
        int width = node.getInt("width", DEFAULT_WIDTH);
        int height = node.getInt("height", DEFAULT_HEIGHT);
        setBounds(left, top, width, height);
        image = node.get("image", null);
        var label = new JLabel();
        if (image != null) label.setIcon(new ImageIcon(image));

        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent event)
            {
                node.putInt("left", getX());
                node.putInt("top", getY());
                node.putInt("width", getWidth());
                node.putInt("height", getHeight());
                node.put("image", image);
            }
        });

        // u�ycie etykiety do wy�wietlania obraz�w
        add(label);

        // element wyboru pliku
        var chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        // pasek menu
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        var menu = new JMenu("Plik");
        menuBar.add(menu);

        var openItem = new JMenuItem("Otw�rz");
        menu.add(openItem);
        openItem.addActionListener(event -> {
            // wy�wietla okno dialogowe wyboru pliku
            int result = chooser.showOpenDialog(null);

            // je�li plik zostanie wybrany, ustawia go jako ikon� etykiety
            if (result == JFileChooser.APPROVE_OPTION)
            {
                image = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(image));
            }
        });

        var exitItem = new JMenuItem("Zamknij");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));
    }
}
