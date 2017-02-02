package src.model.entity.unit;
package src.model.common;

abstract public class Unit {
    private ArrayList<Location> currentPath;
    private Location currentLocation;

    public Unit() {
        currentPath = new ArrayList<Location>();

    }

    abstract public boolean moveUnit(Location targetLocation);

}