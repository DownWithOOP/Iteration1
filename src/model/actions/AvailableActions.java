package model.actions;

import controllers.kyeboardInputHandler.TypeOfActions;

import java.util.HashMap;

/**
 * Created by jordi on 2/1/2017.
 */
public class AvailableActions {
    HashMap<TypeOfActions, Action> actionMap=new HashMap<>();

    public void executeAction(TypeOfActions typeOfAction) {
        if (actionMap.containsKey(typeOfAction)) {
            actionMap.get(typeOfAction).addToQueue();
        }
    }

    public void addAction(){

    }
}
