package model.actions;

import controllers.keyboardInputHandler.TypeOfActions;

import java.util.HashMap;

/**
 * Created by jordi on 2/2/2017.
 * used to handle available actions,
 * only classes that inherit from this can add actions to Available Actions
 */
public abstract class ContainsActions {
    protected HashMap<TypeOfActions, Action> actionsMap = new HashMap<>();

    protected ContainsActions(){
    }

    public HashMap<TypeOfActions,Action> getActions(){
        return actionsMap;
    };
    protected abstract void addAvailableActions();
    protected abstract void removeAvailableActions();


    protected void addAllActions( HashMap<TypeOfActions,Action> actionsMap){

        if (actionsMap !=null) {
            this.actionsMap.putAll(actionsMap);
        }
    }

}
