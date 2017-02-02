package controllers;

import model.actions.Action;
import model.actions.AvailableActions;

import java.util.HashMap;

abstract public class Controller{
//    protected View view;
    protected StateManager stateManager;
    protected HashMap<Integer, Action> controllerActions;
    protected AvailableActions availableActions= new AvailableActions();

    public Controller(/*View view,*/ StateManager stateManager){
        //this.view=view;
        this.stateManager= stateManager;
        controllerActions= new HashMap<>();
        initialize();
    }
    abstract public boolean update();
    abstract protected boolean changeController();
    abstract protected void initialize();

    protected boolean updateView(){
        boolean returnValue=false;
        //   returnValue=view.update();
        return returnValue;
    }

    protected boolean addAvailabeActions(){
        boolean returnValue=false;
        //returnValue=availableActions.addActions(controllerActions);
        return returnValue;
    }

    protected void addControllerActions(HashMap<Integer,Action> customizedControl ){
        controllerActions=customizedControl;
    }

    protected boolean removeAvailableActions(){
        boolean returnValue=false;
        //returnValue=availableActions.removeActions(controllerActions);
        return returnValue;
    }

    protected boolean onKeyPressed(int input){
        boolean returnValue=false;
        //returnValue=availableActions.executeAction(input);
        return returnValue;
    }

}