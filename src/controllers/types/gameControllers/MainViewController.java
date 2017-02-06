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
import model.common.RenderObject;
import model.entity.stats.StructureStats;
import model.entity.structure.Base;
import model.entity.structure.Structure;
import model.map.Map;
import model.player.Player;
import view.View;
import view.types.MainView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by jordi on 2/1/2017.
 */
public class MainViewController extends GameController {
    protected HashMap<TypeOfActions, Action> mainViewControllerActions = new HashMap<>();

    private MainView mainView;


    public MainViewController(StateManager stateManager, int mainViewWidth, int mainViewHeight) {
        super(stateManager);
        setView(gameModel.getRenderObject(), mainViewWidth, mainViewHeight);

        initializeMainController();
        //a = new ChangeViewAction(this);
    }

    protected void initializeMainController() {
        addAllActions(mainViewControllerActions);
    }

    @Override
    protected void updateGameModel() {
        gameModel.update();
    }

    @Override
    protected void updateView() {
    }

    //TODO: change public modifier
    @Override
    public void update() {
        updateGameModel();
        updateView(gameModel.getRenderObject());
    }

    @Override
    protected void setView() {

    }

    protected void setView(RenderObject renderInfo, int mainViewWidth, int mainViewHeight) {
        // this method is called when the class is initialized, we create our view that corresponds to the controller
        this.mainView = new MainView(new GridBagLayout(), renderInfo, mainViewWidth, mainViewHeight);
    }

    protected void updateView(RenderObject renderInfo) {
        mainView.update(renderInfo);
    }

    @Override
    public View returnViewToStateManager() {
        return this.mainView;
    }

}
