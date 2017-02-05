package model.entity.structure;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.entity.army.Army;
import model.entity.army.RallyPoint;
import model.entity.unit.*;
import model.common.Location;
import model.entity.stats.StructureStats;
import model.player.Player;

import java.util.HashMap;

/**
 * Created by jordi on 2/2/2017.
 */
public class Base extends Structure {
    protected HashMap<TypeOfActions, Action> baseActions = new HashMap<>();
    RallyPoint unitsRallyPoint;


    public Base(StructureStats baseStats, int xPosition, int yPosition, Player player) {
        super(baseStats, xPosition, yPosition, player);
        initializeBase();
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
    public boolean createUnit(String unitType, boolean isReinforcement) {
        Unit newUnit;

        if (unitType.equals("COLONIST")) {
            newUnit = new Colonist(player,unitsRallyPoint.getLocation());
            return true;
        }
        else if (unitType.equals("EXPLORER")) {
            newUnit = new Explorer(player, unitsRallyPoint.getLocation());
            return true;
        }
        else if (unitType.equals("MELEE")) {
            newUnit = new Melee(player, unitsRallyPoint.getLocation());
            return true;
        }
        else if (unitType.equals("RANGED")) {
            newUnit = new Ranged(player, unitsRallyPoint.getLocation());
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
    //TODO: FIX THIS
    private void setRallypoint(Location location){
        unitsRallyPoint= new RallyPoint(location,new Army(player,location));
    }
    //TODO: manage this so that no obstacle can block the rally point
    private void setDefaultRallypoint(){
        Location fxlocation= getFixedLocation();
        Location location= new Location(fxlocation.getxCoord()-1, fxlocation.getyCoord());
        setRallypoint(location);
    }
}
