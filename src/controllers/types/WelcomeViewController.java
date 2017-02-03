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
    public void update() {
        changeController();
    }

    @Override
    protected void changeController() {
        super.stateManager.changeController(TypeOfControllers.MainViewController);

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
