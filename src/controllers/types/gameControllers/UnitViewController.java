package controllers.types.gameControllers;

import view.types.UnitView;
import controllers.Controller;
import controllers.StateManager;
import controllers.types.GameController;
import view.View;

import java.awt.event.KeyEvent;

/**
 * Created by jordi on 2/1/2017.
 */
public class UnitViewController extends GameController {

    private UnitView unitView;
    public UnitViewController(StateManager stateManager) {
        super(stateManager);

    }

    @Override
    protected void updateGameModel() {

    }

    @Override
    public void update() {

    }

    @Override
    protected void setView() {
        this.unitView = new UnitView();
    }

    @Override
    protected void updateView() {

    }

    @Override
    public View returnViewToStateManager() {
        return this.unitView;
    }


}
