package controllers.types.gameControllers;

import controllers.Controller;
import controllers.StateManager;
import controllers.TypeOfControllers;
import controllers.keyboardInputHandler.KeyBoardMapManager;
import controllers.keyboardInputHandler.TypeOfActions;
import controllers.types.GameController;
import model.GameModel;
import model.actions.Action;
import model.actions.controllerActions.ChangeViewAction;
import view.types.MainView;

import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by jordi on 2/1/2017.
 */
public class MainViewController extends GameController {
    private final MainView mainView = new MainView();

    public MainViewController(StateManager stateManager) {
        super(stateManager);
        startGameModel();
        a = new ChangeViewAction(this);
    }

    private void startGameModel(){
        gameModel= new GameModel();
    }

    @Override
    protected void updateGameModel() {
//        gameModel.update();
    }

    //TODO: change public modifier
    @Override
    public void update() {
        a.execute();
        updateGameModel();
        updateView();
    }

    @Override
    protected void handleKeyPressed(KeyEvent e) {

    }

    @Override
    protected void handleKeyReleased(KeyEvent e) {

    }

    Action a;

    @Override
    protected void setView() {
        super.view = mainView;
    }

    //TODO: view.update
    @Override
    protected void updateView() {
    }

    @Override
    protected void setControllerActions() {
        ChangeViewAction changeViewAction = new ChangeViewAction(this);
        super.controllerActions.put(TypeOfActions.changeView, changeViewAction);
    }

    //TODO: delete this one, take care of handleInput
    public static void main(String[] args) {
        StateManager stateManager= new StateManager();
        MainViewController mainViewController = new MainViewController(stateManager);
        KeyBoardMapManager keyBoardMapManager = new KeyBoardMapManager();

        HashMap<TypeOfActions,String> playerInput= new HashMap<>();
        playerInput.put(TypeOfActions.changeView,"1");

        keyBoardMapManager.populatePlayerInputHash("Player1",playerInput);
        keyBoardMapManager.updatePlayerId("Player1");

        mainViewController.handleInput(keyBoardMapManager,"1");
        mainViewController.changeView(TypeOfControllers.MainViewController);
    }
}


















