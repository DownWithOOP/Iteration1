package model.actions.armyRallyPointActions;

import model.actions.Action;
import model.actions.ActionModifiers;
import model.common.Location;
import model.entity.army.Army;
import model.entity.army.RallyPoint;
import model.player.Player;

/**
 * Created by jordi on 2/4/2017.
 */
public class MoveRallyPointAction implements Action {
    RallyPoint rallyPoint;
    ActionModifiers actionModifier= ActionModifiers.none;
    public MoveRallyPointAction(RallyPoint rallyPoint){
        this.rallyPoint=rallyPoint;
    }

    @Override
    public void execute() {
        rallyPoint.moveRallyPoint(actionModifier);
    }

    @Override
    public void applyModifier(ActionModifiers actionModifier) {
        this.actionModifier=actionModifier;
    }

    public static void main(String[] args) {
        RallyPoint rallyPoint= new RallyPoint(new Location(1,2), new Army(new Player("hello"),new Location(1,2)));
        MoveRallyPointAction moveRallyPointAction=new MoveRallyPointAction(rallyPoint);
        moveRallyPointAction.applyModifier(ActionModifiers.down);
    }
}
