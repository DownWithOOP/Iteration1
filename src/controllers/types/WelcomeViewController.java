package controllers.types;

import controllers.Controller;
import controllers.StateManager;
import controllers.TypeOfControllers;

import java.awt.event.KeyEvent;

/**
 * Created by jordi on 2/1/2017.
 */
public class WelcomeViewController extends Controller {
    public WelcomeViewController(StateManager stateManager) {
        super(stateManager);
    }

    @Override
    protected void handleKeyPressed(KeyEvent e) {
        System.out.println("=================================== Welcome View Controller event handler");
        if(e.getKeyChar() == 'c'){
            System.out.println("Changing to MAIN VIEW CONTROLLER");
            this.changeController(); // doesn't work correctly yet
            super.stateManager.changeController(TypeOfControllers.MainViewController);
        }
        System.out.println(e.toString());

    }

    @Override
    protected void handleKeyReleased(KeyEvent e) {

    }

    @Override
    public boolean update() {
        boolean checkIfControllerWasChanged=changeController();
        return false;
    }

    @Override
    protected boolean changeController() {
        return false;
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
    protected boolean updateView() {
        return false;
    }

    @Override
    protected boolean updateGameManager() {
        return false;
    }
}
