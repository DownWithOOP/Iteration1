package model.actions.controllerActions;

import model.actions.ActionModifiers;
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
    public void execute() {
        System.out.println("HelloWorld!");
    }

    @Override
    public void applyModifier(ActionModifiers actionModifier) {

    }

}
