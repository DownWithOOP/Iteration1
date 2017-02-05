package controllers.types.gameControllers;

import view.types.StructureView;
import controllers.Controller;
import controllers.StateManager;
import controllers.types.GameController;
import view.View;

import java.awt.event.KeyEvent;

/**
 * Created by jordi on 2/1/2017.
 */
public class StructureViewController extends GameController {

    private StructureView structureView;
    public StructureViewController(StateManager stateManager) {
        super(stateManager);
    }

    @Override
    public void update() {

    }

    @Override
    protected void setView() {
        this.structureView = new StructureView();
    }

    @Override
    protected void updateView() {

    }

    @Override
    public View returnViewToStateManager() {
        return this.structureView;
    }

    @Override
    protected void updateGameModel() {

    }
}
