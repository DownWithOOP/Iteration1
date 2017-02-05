package model.entity.unit;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.entity.Entity;
import model.entity.stats.UnitStats;
import model.common.Location;
import model.player.Player;
import model.entity.unit.EntityType;

import java.util.ArrayList;
import java.util.HashMap;

//    TODO: unit needs a findPath function
//    TODO: unit needs a changeTarget location that would clear the current path and set a new current path
abstract public class Unit extends Entity {

    protected HashMap<TypeOfActions, Action> unitActions = new HashMap<>();
    private ArrayList<Location> currentPath;                                // currentPath stores each tile coordinate for the current path the unit is moving in
    private Location currentLocation;                                   // stores the current position on the map of the unit
    private UnitStats unitStats;


    public Unit(EntityType entityType, UnitStats unitStats, Player player, Location location) {
        super(player, entityType);
        initializeUnit();
        //this.entityType = entityType;
        this.unitStats = unitStats;
        currentLocation=location;
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

    /**
     * Actions
     */
    abstract public boolean moveUnit(int x, int y);

    @Override
    public boolean decommission(){
        return player.removeUnit(this);
    }

    public ArrayList<Location> getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(ArrayList<Location> currentPath) {
        this.currentPath = currentPath;
    }

    @Override
    public void update(){
        //lol
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