package model.actions.controllerActions;

import model.actions.ControllerAction;
import controllers.Controller;

/**
 * Created by jordi on 2/1/2017.
 */
public class ChangeViewAction extends ControllerAction {

    public ChangeViewAction(Controller controller) {
        super(controller);
    }

//TODO:Fix this method, testing for now
    @Override
    public boolean execute() {
        System.out.println("HelloWorld!");
        return false;
    }

    @Override
    public boolean addToQueue() {
        return false;
    }
}
