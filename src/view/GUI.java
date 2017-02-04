package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Created by Konrad on 2/3/2017.
 */
public class GUI {
    private int screenHeight;
    private int screenWidth;

    public JFrame frame; // public so any of the views can access it as well as the stateManager

    public GUI(){ // this is where the GUI is created
        frame = new JFrame("Space Cats");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenHeight = screenSize.height;
        screenWidth = screenSize.width;
        frame.setBounds(0, 0, screenWidth, screenHeight);  // and size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);        // Display the window
    }

}
