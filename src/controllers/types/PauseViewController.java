package controllers.types;

import controllers.Controller;
import controllers.StateManager;
import controllers.TypeOfControllers;

import java.awt.event.KeyEvent;

/**
 * Created by Konrad on 2/2/2017.
 */
public class PauseViewController extends Controller {

    public PauseViewController(StateManager stateManager) {
        super(stateManager);
    }

    @Override
    protected void handleKeyPressed(KeyEvent e) {

    }

    @Override
    protected void handleKeyReleased(KeyEvent e) {

    }

    @Override
    public boolean update() {
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
