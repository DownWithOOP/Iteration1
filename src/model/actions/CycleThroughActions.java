package model.actions;

import model.actions.armyRallyPointActions.MoveRallyPointAction;
import model.actions.playerActions.CycleModeAction;
import model.common.Location;
import model.entity.Entity;
import model.entity.army.Army;
import model.entity.army.RallyPoint;
import model.entity.unit.Colonist;
import model.map.Map;
import model.player.Player;

/**
 * Created by jordi on 2/5/2017.
 */
public class CycleThroughActions implements Action {
    ActionModifiers actionModifiers=ActionModifiers.none;
    Entity entity=null;
    RallyPoint rallyPoint=null;

    public CycleThroughActions(Entity entity){
        this.entity=entity;
    }
    public CycleThroughActions(RallyPoint rallyPoint){
        this.rallyPoint=rallyPoint;
    }

    @Override
    public void execute() {
        if (entity!=null){
            entity.cycleThroughActions(actionModifiers);
        }
        else {
            rallyPoint.cycleThroughActions(actionModifiers);
        }
    }

    @Override
    public void applyModifier(ActionModifiers actionModifier) {
        this.actionModifiers=actionModifier;
        execute();
    }

//    public static void main(String[] args) {
//        //Added new playermap argument - Cristian
//        Player player= new Player("hello", new Map());
//        Location location= new Location(1,2);
//        RallyPoint rallyPoint= new RallyPoint(new Location(1,2), new Army(new Player("hello", new Map()),new Location(1,2)),);
//        Colonist colonist=new Colonist(player,location);
//        Action cyrcleToRallypoint= new CycleThroughActions(rallyPoint);
//        Action cyrcleTocolonist= new CycleThroughActions(rallyPoint);
//
//        cyrcleTocolonist.applyModifier(ActionModifiers.left);
//        cyrcleTocolonist.applyModifier(ActionModifiers.right);
//        cyrcleTocolonist.applyModifier(ActionModifiers.right);
//        cyrcleTocolonist.applyModifier(ActionModifiers.left);
//
//    }
}
