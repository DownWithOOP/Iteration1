package model.entity.unit;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.entity.Entity;
import model.entity.stats.UnitStats;
import model.common.Location;
import model.player.Player;

import java.util.ArrayList;
import java.util.HashMap;

//    TODO: unit needs a findPath function
//    TODO: unit needs a changeTarget location that would clear the current path and set a new current path
abstract public class Unit extends Entity {

    protected HashMap<TypeOfActions, Action> unitActions = new HashMap<>();


    // currentPath stores each tile coordinate for the current path the unit is moving in
    private ArrayList<Location> currentPath;

    // stores the current position on the map of the unit
    private Location currentLocation;
    private UnitStats unitStats;

    private UnitType unitType;

    public Unit(UnitType unitType, UnitStats unitStats,Player player) {
        super(player);
        initializeUnit();
        this.unitType = unitType;
        this.unitStats = unitStats;
        currentPath = new ArrayList<Location>();
    }

    protected void initializeUnit() {
        setUnitActions();
        addAllActions(unitActions);
    }

    protected void setUnitActions(){
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

    public UnitType getUnitType(){
        return unitType;
    }

}