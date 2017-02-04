package model.entity.army;

import model.actions.ActionModifiers;
import model.common.Location;

/**
 * Created by jordi on 2/4/2017.
 */
public class RallyPoint {
    private Location location;

    public RallyPoint(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void changeLocation(Location location) {
        this.location = location;
    }

    public boolean moveRallyPoint(ActionModifiers actionModifiers) {
        int xcoordinate = location.getxCoord();
        int ycoordinate = location.getyCoord();
        int previousX = xcoordinate;
        int previousY = ycoordinate;

        if (actionModifiers.equals(ActionModifiers.up)) {
            ycoordinate--;
        }
        if (actionModifiers.equals(ActionModifiers.down)) {
            ycoordinate++;
        }
        if (actionModifiers.equals(ActionModifiers.right)) {
            xcoordinate++;
        }
        if (actionModifiers.equals(ActionModifiers.left)) {
            xcoordinate--;
        }
        //TODO: MAP CHECK TO SEE IF IT WENT OUT OF BOUNDS OR IF ONE CAN MOVE THERE
        if (xcoordinate != previousX) {
            location.setxCoord(xcoordinate);
        } else {
            location.setyCoord(ycoordinate);
        }
        return true;
    }
}
