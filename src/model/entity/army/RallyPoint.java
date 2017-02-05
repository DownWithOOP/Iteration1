package model.entity.army;

import model.actions.ActionModifiers;
import model.common.Location;
import model.map.Map;

/**
 * Created by jordi on 2/4/2017.
 */
public class RallyPoint {
    private Location location;
    //TODO: PASS THE MAP OF THE PLAYER
    Map map =new Map();
    Army army;

    public RallyPoint(Location location, Army army) {
        this.location = location;
        this.army=army;
    }

    public Location getLocation() {
        return location;
    }

//    public void changeLocation(Location location) {
//        this.location = location;
//    }

    public void moveRallyPoint(ActionModifiers actionModifiers) {
        int xCoordinate = location.getxCoord();
        int yCoordinate = location.getyCoord();
        int previousX = xCoordinate;

        if (actionModifiers.equals(ActionModifiers.up)) {
            yCoordinate--;
        }
        if (actionModifiers.equals(ActionModifiers.down)) {
            yCoordinate++;
        }
        if (actionModifiers.equals(ActionModifiers.right)) {
            xCoordinate++;
        }
        if (actionModifiers.equals(ActionModifiers.left)) {
            xCoordinate--;
        }

        if (!map.getTile(xCoordinate,yCoordinate).isPassable()){
            return;
        }

        if (xCoordinate != previousX) {
            location.setxCoord(xCoordinate);
        } else {
            location.setyCoord(yCoordinate);
        }
    }


}
