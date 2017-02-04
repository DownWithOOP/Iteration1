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
import javax.swing.*;

/**
 * Created by jordi on 2/1/2017.
 */
public class MainViewController extends GameController {
    private final MainView mainView;
    private JFrame frame;

    public MainViewController(StateManager stateManager, JFrame frame) {
        super(stateManager);
        mainView = new MainView();
        this.frame = frame;
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
        frame.add(mainView);
        frame.setVisible(true);
        updateGameModel();
        updateView();
    }

    @Override
    protected void handleKeyPressed(KeyEvent e) {
        System.out.println("=================================== Main View Controller event handler");

        System.out.println(e.toString());
    }

    @Override
    protected void handleKeyReleased(KeyEvent e) {

    }

    @Override
    protected void setView() {



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

}


















