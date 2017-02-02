package model.entity.unit;
//package model.common;

abstract public class Unit {
    //private ArrayList<Location> currentPath;
    //private Location currentLocation;

    public Unit() {
        //currentPath = new ArrayList<Location>();

    }

    abstract public boolean moveUnit(Location targetLocation);

}