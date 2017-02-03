package model.actions;

import controllers.keyboardInputHandler.TypeOfActions;

import java.util.HashMap;

/**
 * Created by jordi on 2/2/2017.
 * used to handle available actions,
 * only classes that inherit from this can add actions to Available Actions
 */
public interface ContainsActions {

    HashMap<TypeOfActions,Action> getActions();
    void addAvailableActions();
    void removeAvailableActions();
}
