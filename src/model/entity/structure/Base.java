package model.entity.structure;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.entity.army.RallyPoint;
import model.entity.unit.*;
import model.common.Location;
import model.entity.stats.StructureStats;
import model.player.Player;
import model.entity.unit.EntityType;

import java.util.HashMap;

/**
 * Created by jordi on 2/2/2017.
 */
public class Base extends Structure {
    protected HashMap<TypeOfActions, Action> baseActions = new HashMap<>();
    RallyPoint unitsRallyPoint;


    public Base(StructureStats baseStats, int xPosition, int yPosition, Player player) {
        super(EntityType.BASE,baseStats, xPosition, yPosition, player);
        initializeBase();
    }

    @Override
    public void update() {

    }

    @Override
    public Location getLocation() {
        return getFixedLocation();
    }

    protected void initializeBase() {
        setBaseActions();
        addAllActions(baseActions);
    }

    /**
     * TODO:Place the innate actions here
     * */

    private void setBaseActions(){
        //baseActions.put()
    }



    //TODO: Player needs to obtain newly created unit
    //TODO: create unit command needs to be added to command queue
    // why not create an enum for the unitType
    public boolean createUnit(String unitType, boolean isReinforcement, Location location) {
        Unit newUnit;

        if (unitType.equals(EntityType.COLONIST.toString())) {
            newUnit = new Colonist(player, location);
            return true;
        }
        else if (unitType.equals(EntityType.EXPLORER.toString())) {
            newUnit = new Explorer(player, location);
            return true;
        }
        else if (unitType.equals(EntityType.MELEE.toString())) {
            newUnit = new Melee(player, location);
            return true;
        }
        else if (unitType.equals(EntityType.RANGED.toString())) {
            newUnit = new Ranged(player, location);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean healUnit(Unit unitToHeal, int healOffset) {
        int currentHealth = unitToHeal.getUnitStats().getHealth();
        unitToHeal.getUnitStats().setHealth(currentHealth + healOffset);
        return true;
    }

    //TODO: account for an obstacle blocking the rally point
    private void setRallypoint(Location location){
        unitsRallyPoint= new RallyPoint(location);
    }
    //TODO: manage this so that no obstacle can block the rally point
    private void setDefaultRallypoint(){
        Location fxlocation= getFixedLocation();
        Location location= new Location(fxlocation.getxCoord()-1, fxlocation.getyCoord());
        setRallypoint(location);
    }
}
