package controllers.types;

import controllers.Controller;
import controllers.StateManager;
import model.GameModel;

/**
 * Created by jordi on 2/2/2017.
 */
public abstract class GameController extends Controller {
    static protected GameModel gameModel;

    protected GameController(StateManager stateManager) {
        super(stateManager);
    }
    abstract protected void updateGameModel();

}
