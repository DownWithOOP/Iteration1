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
    }

    @Override
    protected void handleKeyReleased(KeyEvent e) {

    }

    @Override
    public boolean update() {
        boolean checkIfControllerWasChanged=changeController();
        return checkIfControllerWasChanged;
    }

    @Override
    protected boolean changeController() {
        super.stateManager.changeController(TypeOfControllers.MainViewController);
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
