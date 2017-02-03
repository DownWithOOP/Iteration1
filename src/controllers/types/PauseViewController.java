package controllers.types;

import controllers.Controller;
import controllers.StateManager;
import controllers.TypeOfControllers;
/**
 * Created by Konrad on 2/2/2017.
 */
public class PauseViewController extends Controller {

    public PauseViewController(StateManager stateManager) {
        super(stateManager);
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
