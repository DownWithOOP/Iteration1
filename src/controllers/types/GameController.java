package controllers.types;

import controllers.Controller;
import controllers.StateManager;
import model.GameModel;

/**
 * Created by jordi on 2/2/2017.
 * used solely for controllers that interact with the game
 */
public abstract class GameController extends Controller {
    protected static GameModel gameModel = new GameModel();

    protected GameController(StateManager stateManager) {
        super(stateManager);
    }
    abstract protected void updateGameModel();
    abstract protected void updateView();
}
