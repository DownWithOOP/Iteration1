package controllers.types;

import view.View;
import controllers.Controller;
import controllers.StateManager;
import controllers.TypeOfControllers;
import view.types.WelcomeView;
import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created by jordi on 2/1/2017.
 */
public class WelcomeViewController extends Controller {

    private WelcomeView welcomeView;
    public WelcomeViewController(StateManager stateManager, JFrame frame) {
        super(stateManager);
        welcomeView = new WelcomeView();
        frame.add(welcomeView);
        frame.setVisible(true);
    }

    @Override
    public void update() {

    }
    protected void handleKeyPressed(KeyEvent e) {
        System.out.println("=================================== Welcome View Controller event handler");
        if(e.getKeyChar() == '1'){
            System.out.println("Changing to MAIN VIEW CONTROLLER");
            super.stateManager.changeController(TypeOfControllers.MainViewController);
        } else if(e.getKeyChar() == '2'){

        } else if(e.getKeyChar() == '3'){

        }
        else if(e.getKeyChar() == '4'){
            System.exit(0);
        } else {
            // do nothing
        }
        System.out.println(e.toString());

    }

    @Override
    protected void handleKeyReleased(KeyEvent e) {

    }


    @Override
    protected void initialize() {

    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setControllerActions() {

    }

    @Override
    protected void updateView() {

    }
}
