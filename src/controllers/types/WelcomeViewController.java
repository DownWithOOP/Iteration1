package controllers.types;

import controllers.Controller;
import controllers.StateManager;
import controllers.TypeOfControllers;

/**
 * Created by jordi on 2/1/2017.
 */
public class WelcomeViewController extends Controller {
    public WelcomeViewController(StateManager stateManager) {
        super(stateManager);
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
}
