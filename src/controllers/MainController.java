package controllers;

import model.actions.Action;
import model.actions.controllerActions.ChangeViewAction;

import java.util.HashMap;

/**
 * Created by jordi on 2/1/2017.
 */
public class MainController extends Controller {
//    TODO: GameManager gameManager;
 HashMap<Integer,Action> mainControllerInput;
 final String array[]={"2","s","g","j"};
    public MainController(StateManager stateManager){
        super(stateManager);
    }



    @Override
    public boolean update() {
        a.execute();
        //TODO: call gameManager.update();
        //TODO: super.view.update(pass parameters);
        return false;
    }



    @Override
    protected boolean changeController() {
        return false;
    }
    Action a;
    @Override
    protected void initialize() {
        a= new ChangeViewAction(this);
        //mainControllerInput.put(5,a);
       // super.addControllerActions();
    }
    //TODO: add game model reference UML diagram



}
