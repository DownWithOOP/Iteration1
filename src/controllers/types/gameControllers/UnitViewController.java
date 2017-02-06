package controllers.types.gameControllers;

import model.common.RenderObject;
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
        this.setView(gameModel.getRenderObject());
    }
    protected void setView(RenderObject renderInfo) {
        // this method is called when the class is initialized, we create our view that corresponds to the controller
        this.unitView = new UnitView(renderInfo);
    }

    @Override
    protected void updateView() {

    }

    @Override
    public View returnViewToStateManager() {
        return this.unitView;
    }


}
