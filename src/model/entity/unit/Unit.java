package model.entity.unit;
import model.common.Location;

import java.util.ArrayList;


abstract public class Unit {
    //private ArrayList<Location> currentPath;
    private Location currentLocation;

    public Unit() {
        //currentPath = new ArrayList<Location>();

    }

    abstract public boolean moveUnit(Location targetLocation);

}