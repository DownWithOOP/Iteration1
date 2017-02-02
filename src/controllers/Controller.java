package controllers;

import controllers.kyeboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.actions.AvailableActions;
import view.View;

import java.util.HashMap;

abstract public class Controller {
    protected View view;
    protected StateManager stateManager;
    protected HashMap<TypeOfActions, Action> controllerActions;
    protected static AvailableActions availableActions = new AvailableActions();

    protected Controller(StateManager stateManager) {
        this.stateManager = stateManager;
        controllerActions = new HashMap<>();
        initialize();
    }

    abstract public boolean update();

    abstract protected boolean changeController();

    abstract protected void setView();

    abstract protected void setControllerActions();

    abstract protected boolean updateView();



    //TODO: check if the below method makes sense
    /*protected boolean updateView() {
        boolean returnValue = false;
        returnValue = view.update();
        return returnValue;
    }*/
    protected void initialize() {
        setView();
        setControllerActions();
        resumeController();
    }

    protected void addAvailabeActions() {
        availableActions.addActions(controllerActions);
    }

    protected void removeAvailableActions() {
        availableActions.removeActions(controllerActions);
    }

    protected void resumeController() {
        addAvailabeActions();
    }

    protected void leaveController() {
        removeAvailableActions();
    }

    protected boolean onKeyPressed(int input) {
        boolean returnValue = false;
        //returnValue=availableActions.executeAction(input);
        return returnValue;
    }


}