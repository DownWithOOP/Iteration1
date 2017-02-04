package model.entity.unit;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.entity.Entity;
import model.entity.stats.UnitStats;
import model.common.Location;

import java.util.ArrayList;
import java.util.HashMap;


abstract public class Unit extends Entity {

    protected HashMap<TypeOfActions, Action> unitActions = new HashMap<>();


    // currentPath stores each tile coordinate for the current path the unit is moving in
    private ArrayList<Location> currentPath;

    // stores the current position on the map of the unit
    private Location currentLocation;
    private UnitStats unitStats;

    public Unit(UnitStats unitStats) {
        super();
        this.unitStats = unitStats;
        currentPath = new ArrayList<Location>();
        this.initialize();

    }

    @Override
    protected void initialize() {
        setActions();
        addAllActions(unitActions);
    }

    @Override
    protected void setActions(){
        /**
         *         unitActions.put(TypeOfActions.powerUp,PowerUpAction(this));
         * */
    }

    abstract public boolean moveUnit(int x, int y);

    public ArrayList<Location> getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(ArrayList<Location> currentPath) {
        this.currentPath = currentPath;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(int xPosition, int yPosition) {
        currentLocation.setxCoord(xPosition);
        currentLocation.setyCoord(yPosition);
    }

    public UnitStats getUnitStats() {
        return unitStats;
    }


}