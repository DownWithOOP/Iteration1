package model.entity.structure;

import model.entity.unit.*;
import model.common.Location;
import model.entity.stats.StructureStats;

/**
 * Created by jordi on 2/2/2017.
 */
public class Base extends Structure {
    public Base(StructureStats baseStats, int xPosition, int yPosition) {
        super(baseStats, xPosition, yPosition);
    }

    @Override
    public Location getLocation() {
        return getFixedLocation();
    }

    //TODO: Player needs to obtain newly created unit
    //TODO: create unit command needs to be added to command queue
    public boolean createUnit(String unitType, boolean isReinforcement) {
        Unit newUnit;
        if (unitType.equals("COLONIST")) {
            newUnit = new Colonist();
            return true;
        }
        else if (unitType.equals("EXPLORER")) {
            newUnit = new Explorer();
            return true;
        }
        else if (unitType.equals("MELEE")) {
            newUnit = new Melee();
            return true;
        }
        else if (unitType.equals("RANGED")) {
            newUnit = new Ranged();
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
