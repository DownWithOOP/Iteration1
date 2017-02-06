package model.actions.playerActions;

import model.actions.Action;
import model.actions.ActionModifiers;
import model.entity.Entity;

/**
 * Created by cduica on 2/5/17.
 */
public abstract class EntityAction implements Action {

    Entity entity;
    double numTurns;

    public EntityAction(Entity entity, double numTurns){
        this.entity = entity;
        this.numTurns = numTurns;
    }

    public double getTurns(){
        return numTurns;
    }

    public void setTurns(double numTurns){
        this.numTurns = numTurns;
    }

}
