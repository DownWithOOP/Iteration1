package model.actions.controllerActions;

import model.actions.ActionModifiers;
import model.actions.ContainsActions;
import model.actions.ControllerAction;
import controllers.Controller;

/**
 * Created by jordi on 2/1/2017.
 */
public class ChangeViewAction extends ControllerAction {
    Controller controller=null;
    ActionModifiers actionModifier=ActionModifiers.none;

    public ChangeViewAction(Controller controller) {
        super(controller);
        this.controller=controller;
    }

//TODO:Fix this method, testing for now
    @Override
    public void execute() {
        controller.changeView(actionModifier);
    }

    @Override
    public void applyModifier(ActionModifiers actionModifier) {
        this.actionModifier=actionModifier;
        execute();
    }

    @Override
    public String toString() {
        return "Change View";
    }
}
