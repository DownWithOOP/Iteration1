package controllers.types.gameControllers;

import model.common.RenderObject;
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
        this.setView(gameModel.getRenderObject());
    }

    protected void setView(RenderObject renderInfo) {
        // this method is called when the class is initialized, we create our view that corresponds to the controller
        this.structureView = new StructureView(renderInfo);
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
