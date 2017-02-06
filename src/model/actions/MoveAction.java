package model.actions;

import model.actions.playerActions.EntityAction;
import model.common.Location;
import model.entity.Entity;
import model.entity.unit.Unit;

/**
 * Created by LesliesLaptop on 2/6/17.
 */
public class MoveAction extends EntityAction {


    Location location;

    public MoveAction(Entity entity, Location location){
        super(entity, 1);
        this.location = location;
    }

    @Override
    public void execute() {
        ((Unit) entity).setCurrentLocation(location.getxCoord(), location.getyCoord());
    }

    @Override
    public void applyModifier(ActionModifiers actionModifier) {

    }
}
