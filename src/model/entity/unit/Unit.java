package model.entity.unit;
import model.entity.Entity;
import model.entity.stats.UnitStats;
import model.common.Location;

import java.util.ArrayList;


abstract public class Unit extends Entity {
    // currentPath stores each tile coordinate for the current path the unit is moving in
    private ArrayList<Location> currentPath;

    // stores the current position on the map of the unit
    private Location currentLocation;
    private UnitStats unitStats;

    public Unit(int offensiveDamage, int defensiveDamage, int armor, int movement, int health, int upkeep, int visionRadius) {
        super(visionRadius);
        unitStats = new UnitStats(offensiveDamage, defensiveDamage, armor, movement, health, upkeep, visionRadius);
        currentPath = new ArrayList<Location>();

    }

    abstract public boolean moveUnit(Location targetLocation);

    public ArrayList<Location> getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(ArrayList<Location> currentPath) {
        this.currentPath = currentPath;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
}