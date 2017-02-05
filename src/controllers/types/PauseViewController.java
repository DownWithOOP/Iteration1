package controllers.types;

import controllers.types.GameController;
import controllers.Controller;
import controllers.StateManager;

import controllers.TypeOfControllers;
import view.View;
import view.types.PauseView;

import java.awt.event.KeyEvent;

/**
 * Created by Konrad on 2/2/2017.
 */
public class PauseViewController extends Controller {

    private PauseView pauseView;

    public PauseViewController(StateManager stateManager) {
        super(stateManager);
    }


    public void update() {
    }

    protected void initializePauseViewController() {

    }
    protected void handleInput(){

    }

    @Override
    protected void setView() {
        this.pauseView = new PauseView();
    }

    protected void setPauseViewControllerActions() {

    }

    @Override
    protected void updateView() {

    }

    @Override
    public View returnViewToStateManager() {
        return this.pauseView;
    }
}
