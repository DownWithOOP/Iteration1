package controllers;

import controllers.keyboardInputHandler.KeyBoardMapManager;
import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.ActionModifiers;
import model.actions.ContainsActions;
import model.actions.controllerActions.ChangeViewAction;
import view.View;

import java.util.HashMap;


abstract public class Controller extends ContainsActions {

//TODO figure out the correct way to hide/show views upon resume/leave

    protected View view;
    protected StateManager stateManager;
    protected static KeyBoardMapManager keyBoardMapManager=new KeyBoardMapManager();

    protected Controller(StateManager stateManager) {
        this.stateManager = stateManager;
        actionsMap = new HashMap<>();
        intitializeC();
    }

    abstract public void update();

    abstract protected void setView();

    abstract protected void updateView();

    abstract public View returnViewToStateManager();


    protected void intitializeC(){
        setActionsControllerActions();
        addAllActions(actionsMap);
        initializeController();
        addAvailableActions();
    }

    protected void initializeController() {
        setView();
    }

    protected void setActionsControllerActions() {
        ChangeViewAction changeViewAction = new ChangeViewAction(this);
        actionsMap.put(TypeOfActions.changeView, changeViewAction);
    }



    @Override
    public void resume() {
        intitializeC();
    }

    public void changeView(ActionModifiers actionModifier){
        TypeOfControllers typeOfController=TypeOfControllers.None;
        switch (actionModifier){
            case one:
                typeOfController=TypeOfControllers.MainViewController;
                break;
            case two:
                typeOfController=TypeOfControllers.StructureViewController;
                break;
            case three:
                typeOfController=TypeOfControllers.UnitViewController;
                break;
            case four:
                typeOfController=TypeOfControllers.PauseViewController;
                break;
        }
        leave();
        stateManager.changeController(typeOfController);
    }

    @Override
    public void leave( ) {
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