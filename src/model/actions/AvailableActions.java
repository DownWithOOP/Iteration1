package model.actions;

import controllers.kyeboardInputHandler.TypeOfActions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jordi on 2/1/2017.
 */
public class AvailableActions {
    private static HashMap<TypeOfActions, Action> actionMap = new HashMap<>();

    public void executeAction(TypeOfActions typeOfAction) {
        if (actionMap.containsKey(typeOfAction)) {
            actionMap.get(typeOfAction).addToQueue();
            actionMap.get(typeOfAction).execute();
        }
    }

    public void addActions(HashMap<TypeOfActions, Action> currentAvailableActions) {
        for (Map.Entry<TypeOfActions, Action> iterator :
                currentAvailableActions.entrySet()) {
            TypeOfActions key = iterator.getKey();
            Action value = iterator.getValue();
            actionMap.put(key,value);
        }
    }
    public void removeActions(HashMap<TypeOfActions, Action> currentAvailableActions) {
        for (TypeOfActions iterator :  currentAvailableActions.keySet()) {
            actionMap.remove(iterator);
        }
    }
}
