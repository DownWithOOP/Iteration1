package controllers.types;

import controllers.Controller;
import controllers.StateManager;
import controllers.kyeboardInputHandler.KeyBoardMapManager;
import model.actions.Action;
import model.actions.controllerActions.ChangeViewAction;
import sun.applet.Main;
import view.View;
import view.types.MainView;

import java.util.HashMap;

/**
 * Created by jordi on 2/1/2017.
 */
public class MainViewController extends Controller {
    //    TODO: GameManager gameManager;
    private final MainView mainView = new MainView();

    public MainViewController(StateManager stateManager) {
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
        a = new ChangeViewAction(this);
        //mainControllerInput.put(5,a);
        // super.addControllerActions();
        setView();
    }

    @Override
    protected void setView() {
        super.view = mainView;
    }

    @Override
    protected boolean updateView() {
        return false;
    }
    //TODO: add game model reference UML diagram

    @Override
    protected void setControllerActions() {
        //        super.controllerActions.put()
    }

    private void interpretInput(KeyBoardMapManager keyBoardMapManager,int input){
        keyBoardMapManager.processInput(input);
    }

    //TODO: delete this one
//    public static void main(String[] args) {
//        StateManager stateManager= new StateManager();
//        MainViewController mainViewController = new MainViewController(stateManager);
//        KeyBoardMapManager keyBoardMapManager = new KeyBoardMapManager();
//        keyBoardMapManager.updatePlayerId("Player1");
//        mainViewController.interpretInput(keyBoardMapManager,1);
//    }
}
