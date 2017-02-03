package controllers;

import java.awt.event.KeyEvent;
import com.sun.xml.internal.bind.annotation.XmlLocation;
import controllers.keyboardInputHandler.KeyBoardMapManager;
import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.actions.AvailableActions;
import model.actions.ContainsActions;
import view.View;

import java.util.HashMap;

abstract public class Controller implements ContainsActions {
    protected View view;
    protected StateManager stateManager;
    protected HashMap<TypeOfActions, Action> controllerActions;
    protected static AvailableActions availableActions = new AvailableActions();

    protected Controller(StateManager stateManager) {
        this.stateManager = stateManager;
        controllerActions = new HashMap<>();
        initialize();
    }


    abstract public void update();


    abstract protected void handleKeyPressed(KeyEvent e);

    abstract protected void handleKeyReleased(KeyEvent e);




    abstract protected void setView();

    abstract protected void setControllerActions();

    abstract protected void updateView();

    protected void initialize() {
        setView();
        setControllerActions();
        resumeController();
    }

    @Override
    public void addAvailableActions() {
        availableActions.addActions(this);
    }

    @Override
    public void removeAvailableActions() {
        availableActions.removeActions(this);
    }

    @Override
    public HashMap<TypeOfActions, Action> getActions() {
        return controllerActions;
    }

    public void resumeController() {
        addAvailableActions();
    }

    protected void changeView(TypeOfControllers typeOfControllers){
        leaveController();
        stateManager.changeController(typeOfControllers);
    }

    protected void leaveController( ) {
        removeAvailableActions();
    }

    protected void onKeyPressed(int input) {
        boolean returnValue = false;
        //returnValue=availableActions.executeAction(input);
    }

    protected void handleInput(KeyBoardMapManager keyBoardMapManager, String input) {
        TypeOfActions typeOfActions = keyBoardMapManager.processInput(input);
        availableActions.executeAction(typeOfActions);
    }


}