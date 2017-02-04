package controllers.types.gameControllers;

import controllers.Controller;
import controllers.StateManager;
import controllers.TypeOfControllers;
import controllers.keyboardInputHandler.KeyBoardMapManager;
import controllers.keyboardInputHandler.TypeOfActions;
import controllers.types.GameController;
import model.GameModel;
import model.actions.Action;
import model.actions.ActionModifiers;
import model.actions.ContainsActions;
import model.actions.controllerActions.ChangeViewAction;
import model.common.Location;
import model.entity.stats.StructureStats;
import model.entity.structure.Base;
import model.entity.structure.Structure;
import view.types.MainView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by jordi on 2/1/2017.
 */
public class MainViewController extends GameController {
    protected HashMap<TypeOfActions, Action> mainViewControllerActions = new HashMap<>();

    private final MainView mainView = new MainView(new BorderLayout());

    public MainViewController(StateManager stateManager) {
        super(stateManager);
        startGameModel();
        initializeMainController();
        a = new ChangeViewAction(this);
    }

    protected void initializeMainController() {
        setMainViewControllerActions();
        addAllActions(mainViewControllerActions);
    }


    private void startGameModel() {
        gameModel = new GameModel();
    }

    @Override
    protected void updateGameModel() {
        gameModel.update();
    }

    Action a; //TODO used for testing purposes

    //TODO: change public modifier
    @Override
    public void update() {
        a.execute();
        updateGameModel();
        updateView();
    }


    @Override
    protected void setView() {
        super.view = mainView;
    }

    //TODO: view.update
    @Override
    protected void updateView() {
        mainView.update();
    }


    protected void setMainViewControllerActions() {
//        ChangeViewAction changeViewAction = new ChangeViewAction(this);
//        mainViewControllerActions.put(TypeOfActions.changeView, changeViewAction);
    }

    //TODO: delete this one, take care of handleInput
//    public static void main(String[] args) {
//        StateManager stateManager = new StateManager();
//        MainViewController mainViewController = new MainViewController(stateManager);
//        KeyBoardMapManager keyBoardMapManager = new KeyBoardMapManager();
//
////        HashMap<TypeOfActions,String> playerInput= new HashMap<>();
////        playerInput.put(TypeOfActions.changeView,"1");
////
////        keyBoardMapManager.populatePlayerInputHash("Player1",playerInput);
////        keyBoardMapManager.updatePlayerId("Player1");
////
////        mainViewController.handleInput(keyBoardMapManager,"1", ActionModifiers.down);
////        mainViewController.changeView(TypeOfControllers.MainViewController);
//        StructureStats structureStats= new StructureStats(5,6,7,8,9,9,9,9);
//        Base base=new Base(structureStats,5,7);
//
//    }
}


















