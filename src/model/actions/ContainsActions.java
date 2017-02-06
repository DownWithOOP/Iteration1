package model.actions;

import controllers.keyboardInputHandler.TypeOfActions;
import model.player.ComplexDataStructure;

import java.util.*;

/**
 * Created by jordi on 2/2/2017.
 * used to handle available actions,
 * only classes that inherit from this can add actions to Available Actions
 */
public abstract class ContainsActions {
    protected HashMap<TypeOfActions, Action> actionsMap = new HashMap<>();
    private List<TypeOfActions> actionList = new ArrayList<>();
    protected static AvailableActions availableActions = new AvailableActions();
    private boolean isListCreated = false;
    int listIndex = 0;

    protected ContainsActions() {
    }

    public HashMap<TypeOfActions, Action> getActions() {
        return actionsMap;
    }

    protected void addAvailableActions() {
        availableActions.addActions(this);
    }

    protected void removeAvailableActions() {
        availableActions.removeActions(this);
    }

    abstract public void resume();

    abstract public void leave();


    protected void addAllActions(HashMap<TypeOfActions, Action> actionsMap) {

        if (actionsMap != null) {
            this.actionsMap.putAll(actionsMap);
        }
    }

    public Action cycleThroughActions(ActionModifiers actionModifiers) {
        if (isListCreated == false) {
            createList();
            isListCreated = true;
        }
        if (actionModifiers == ActionModifiers.left) {
            listIndex= ComplexDataStructure.previous(actionList.size(),listIndex);
        }
        if (actionModifiers == ActionModifiers.right) {
           listIndex= ComplexDataStructure.next(actionList.size(),listIndex);
        }
        return actionsMap.get( actionList.get(listIndex));
    }

    private void createList() {
        for (TypeOfActions typeOfActions :
                actionsMap.keySet()) {
            actionList.add(typeOfActions);
        }
    }

}
