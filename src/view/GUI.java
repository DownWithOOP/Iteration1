package view;

import java.util.*;
import java.awt.*;
import javax.swing.*;


// The main GUI window resides in this class, it is initialized by the StateManager at the very beggining of the game
// Statemanager binds a keylistener to the GUI object it initilized and the keylistender functions are implemented in Statemanager.java
public class GUI {
    private int screenHeight;
    private int screenWidth;

    public JFrame frame;
    private View currentlyActiveView;

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

    // The GUI class will keep track of all the views (Jpanels essentially), everytime the view must be updated, the panel will be removed
    // that is no longer going to be active, and the new currently active panel will be added
    public void updateCurrentView(View addMe){
        // this method will remove the currently displayed view, and add the new disired view that we want to display
        if(this.currentlyActiveView != null){
            this.frame.remove(this.currentlyActiveView);
        }
        this.frame.add(addMe);
        this.frame.getContentPane().validate();
        this.frame.getContentPane().repaint();
        this.frame.setVisible(true);
        this.currentlyActiveView = addMe;
    }

    // this can be called after any of the views do some sort of manipulation and need to be rerendered
    public void repaintCurrentView(){
        this.frame.getContentPane().validate();
        this.frame.getContentPane().repaint();
        this.frame.setVisible(true);
    }

    public int getScreenHeight(){ return screenHeight;}

    public int getScreenWidth(){ return screenWidth;}

}