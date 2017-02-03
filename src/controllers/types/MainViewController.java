package controllers.types;

import controllers.Controller;
import controllers.StateManager;
import controllers.keyboardInputHandler.KeyBoardMapManager;
import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.actions.controllerActions.ChangeViewAction;
import view.types.MainView;

import java.util.HashMap;

/**
 * Created by jordi on 2/1/2017.
 */
public class MainViewController extends Controller {
    //    TODO: GameManager gameManager;
    private final MainView mainView;

    public MainViewController(StateManager stateManager) {
        super(stateManager);
        a = new ChangeViewAction(this);
        mainView = null;//new MainView(stateManager.getRootNode());
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
        super.leaveController();
        return false;
    }

    Action a;


    @Override
    protected void setView() {
        super.view = mainView;
    }

    @Override
    protected boolean updateView() {
        return false;
    }

    //TODO: when game manager is created call gameManager.update();
    @Override
    protected boolean updateGameManager() {
        return false;
    }


    //TODO: add game model reference UML diagram

    @Override
    protected void setControllerActions() {
        ChangeViewAction changeViewAction= new ChangeViewAction(this);
        super.controllerActions.put(TypeOfActions.changeView,changeViewAction);
    }

    //TODO: delete this one, take care of handleInput
//    public static void main(String[] args) {
//        StateManager stateManager= new StateManager();
//        MainViewController mainViewController = new MainViewController(stateManager);
//        KeyBoardMapManager keyBoardMapManager = new KeyBoardMapManager();
//
//        HashMap<TypeOfActions,String> playerInput= new HashMap<>();
//        playerInput.put(TypeOfActions.changeView,"1");
//
//        keyBoardMapManager.populatePlayerInputHash("Player1",playerInput);
//        keyBoardMapManager.updatePlayerId("Player1");
//
//        mainViewController.handleInput(keyBoardMapManager,"1");
//        mainViewController.changeController();
//    }
}


















