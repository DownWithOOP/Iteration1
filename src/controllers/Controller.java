package controllers;

import controllers.keyboardInputHandler.KeyBoardMapManager;
import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.actions.ActionModifiers;
import model.actions.AvailableActions;
import model.actions.ContainsActions;
import view.View;

import java.util.HashMap;

abstract public class Controller extends ContainsActions {
    protected View view;
    protected StateManager stateManager;
    protected static AvailableActions availableActions = new AvailableActions();
    KeyBoardMapManager keyBoardMapManager=new KeyBoardMapManager();

    protected Controller(StateManager stateManager) {
        this.stateManager = stateManager;
        actionsMap = new HashMap<>();
        this.initialize();
    }


    abstract public void update();

    abstract protected void setView();

    abstract protected void updateView();

    @Override
    protected void initialize(){
        initializeController();
    }

    protected void initializeController() {
        setView();
        resumeController();
    }

    @Override
    protected void addAvailableActions() {
        availableActions.addActions(this);
    }

    @Override
    protected void removeAvailableActions() {
        availableActions.removeActions(this);
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

    public void receiveInput(String receivedInput, ActionModifiers actionModifier){
        handleInput(keyBoardMapManager,receivedInput, actionModifier);

    }

    protected void handleInput(KeyBoardMapManager keyBoardMapManager, String input, ActionModifiers actionModifier) {
        TypeOfActions typeOfActions = keyBoardMapManager.processInput(input);
        availableActions.executeAction(typeOfActions, actionModifier);
    }


}