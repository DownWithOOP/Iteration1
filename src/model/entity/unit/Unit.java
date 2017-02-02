package model.entity.unit;
//package src.model.entity.unit;

import model.common.Location;
//package src.model.common;
import java.util.ArrayList;


abstract public class Unit {
    private ArrayList<Location> currentPath;
    private Location currentLocation;

    public Unit() {
        currentPath = new ArrayList<Location>();

    }

    abstract public boolean moveUnit(Location targetLocation);

}