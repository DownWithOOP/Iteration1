package model.entity.structure;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.entity.army.Army;
import model.entity.army.RallyPoint;
import model.entity.unit.*;
import model.common.Location;
import model.entity.stats.StructureStats;
import model.map.Map;
import model.player.Player;
import model.entity.unit.EntityType;

import java.util.HashMap;

/**
 * Created by jordi on 2/2/2017.
 */
public class Base extends Structure {
    protected HashMap<TypeOfActions, Action> baseActions = new HashMap<>();
    RallyPoint unitsRallyPoint;


    public Base(StructureStats baseStats, Location location, Player player) {
        super(EntityType.BASE,baseStats, location, player);
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
        Location unitLocation;

        int fixedX = this.getFixedLocation().getxCoord();
        int fixedY = this.getFixedLocation().getyCoord();
        if ((fixedX + 1 < getPlayer().getPlayerMap().getWidth()) &&
                getPlayer().getPlayerMap().getTile(fixedX + 1, fixedY).isPassable()) {
            unitLocation = new Location(fixedX+1, fixedY);
        }
        else if (fixedX - 1 >= 0 &&
                getPlayer().getPlayerMap().getTile(fixedX - 1, fixedY).isPassable()) {
            unitLocation = new Location(fixedX-1, fixedY);
        }
        else if (fixedY + 1 < getPlayer().getPlayerMap().getHeight() &&
                getPlayer().getPlayerMap().getTile(fixedX, fixedY + 1).isPassable()) {
            unitLocation = new Location(fixedX, fixedY + 1);
        }
        else if (fixedY - 1 >= 0 &&
                    getPlayer().getPlayerMap().getTile(fixedX, fixedY - 1).isPassable()) {
            unitLocation = new Location(fixedX, fixedY - 1);
        }
        else {
            return false;
        }

        if (unitType.equals(EntityType.COLONIST.toString())) {
            newUnit = new Colonist(player, unitLocation);
            getPlayer().addUnit(newUnit);
            System.out.println("COLONIST CREATED");
            return true;
        }
        else if (unitType.equals(EntityType.EXPLORER.toString())) {
            newUnit = new Explorer(player, unitLocation);
            getPlayer().addUnit(newUnit);
            System.out.println("EXPLORER CREATED");
            return true;
        }
        else if (unitType.equals(EntityType.MELEE.toString())) {
            newUnit = new Melee(player, unitLocation);
            getPlayer().addUnit(newUnit);
            System.out.println("MELEE CREATED");
            return true;
        }
        else if (unitType.equals(EntityType.RANGED.toString())) {
            newUnit = new Ranged(player, unitLocation);
            getPlayer().addUnit(newUnit);
            System.out.println("RANGED CREATED");
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

    public static void main(String[] args) {
        Player player = new Player("1", new Map());
        Colonist colonist = new Colonist(player, new Location(0,0));
        colonist.buildStructure();
        Base base = (Base) player.getStructures().get(0);
        base.createUnit("EXPLORER", false);
        System.out.println(player.getUnits().get(player.getUnits().size()-1).getEntityID().getEntityType());
    }

}
