package model.actions;
import controllers.keyboardInputHandler.TypeOfActions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jordi on 2/1/2017.
 */
public class AvailableActions {
    private HashMap<TypeOfActions, Action> actionMap = new HashMap<>();


    //Todo:fix applyModifier
    public void executeAction(TypeOfActions typeOfAction, ActionModifiers actionModifiers) {
        if (actionMap.containsKey(typeOfAction)) {
            actionMap.get(typeOfAction).applyModifier(actionModifiers);
            actionMap.get(typeOfAction).execute();
        }
    }

    public void addActions(ContainsActions actionRelatedClasses) {
        HashMap<TypeOfActions,Action> currentAvailableActions;
        currentAvailableActions=actionRelatedClasses.getActions();

        for (Map.Entry<TypeOfActions, Action> iterator :
                currentAvailableActions.entrySet()) {
            TypeOfActions key = iterator.getKey();
            Action value = iterator.getValue();
            actionMap.put(key,value);
        }
    }
    public void removeActions(ContainsActions actionRelatedClasses) {
        HashMap<TypeOfActions, Action> currentAvailableActions;
        currentAvailableActions= actionRelatedClasses.getActions();

        for (TypeOfActions iterator :  currentAvailableActions.keySet()) {
            actionMap.remove(iterator);
        }
    }
}
