package controllers.types;

import controllers.Controller;
import controllers.StateManager;

/**
 * Created by jordi on 2/1/2017.
 */
public class UnitViewController extends Controller {

    public UnitViewController(StateManager stateManager){
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
}
