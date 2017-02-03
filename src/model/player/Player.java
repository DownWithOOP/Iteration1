package model.player;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.actions.ContainsActions;

import java.util.HashMap;

/**
 * Created by jordi on 2/2/2017.
 */
public class Player implements ContainsActions {

    @Override
    public HashMap<TypeOfActions, Action> getActions() {

        return null;
    }

    @Override
    public void addAvailableActions() {

    }

    @Override
    public void removeAvailableActions() {

    }
}
