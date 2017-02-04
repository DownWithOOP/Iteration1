package model.entity.structure;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
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
            newUnit = new Colonist(player);
            return true;
        }
        else if (unitType.equals("EXPLORER")) {
            newUnit = new Explorer(player);
            return true;
        }
        else if (unitType.equals("MELEE")) {
            newUnit = new Melee(player);
            return true;
        }
        else if (unitType.equals("RANGED")) {
            newUnit = new Ranged(player);
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

}
