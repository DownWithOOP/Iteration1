package utilities;

import model.entity.structure.Structure;
import model.entity.unit.*;

import java.util.ArrayList;

/**
 * Created by ur mom on 2/4/17.
 */
public class EntityList<Entity> extends ArrayList<Entity> {

    private int numUnits;
    private int numStructures;
    private int numColonists;
    private int numExplorers;
    private int numMelee;
    private int numRanged;

    /**
     * Keeps track of numbers of different types of entities.
     */
    @Override
    public boolean add(Entity e){

        if(e instanceof Structure){
            numStructures++;
        } else {
            numUnits++;
            if (((Unit) e).getUnitType().equals(UnitType.COLONIST)) {
                numColonists++;
            } else if (((Unit) e).getUnitType().equals(UnitType.EXPLORER)) {
                numExplorers++;
            } else if (((Unit) e).getUnitType().equals(UnitType.MELEE)) {
                numMelee++;
            } else if (((Unit) e).getUnitType().equals(UnitType.RANGED)) {
                numRanged++;
            }
        }

        return super.add(e);

    }

    /**
     * If the object to be removed is in the list, decrement number.
     */
    @Override
    public boolean remove(Object o) {

        if(super.remove(o)) {
            if (o instanceof Structure) {
                numStructures--;
            } else {
                numUnits--;
                if (((Unit) o).getUnitType().equals(UnitType.COLONIST)) {
                    numColonists--;
                } else if (((Unit) o).getUnitType().equals(UnitType.EXPLORER)) {
                    numExplorers--;
                } else if (((Unit) o).getUnitType().equals(UnitType.MELEE)) {
                    numMelee--;
                } else if (((Unit) o).getUnitType().equals(UnitType.RANGED)) {
                    numRanged--;
                }
            }
            return true;
        }
        return false;

    }

    /**
     * Getters
     */
    public int numUnits() {
        return numUnits;
    }

    public int numStructures() {
        return numStructures;
    }

    public int numColonists() {
        return numColonists;
    }

    public int numExplorers() {
        return numExplorers;
    }

    public int numMelee() {
        return numMelee;
    }

    public int numRanged() {
        return numRanged;
    }
}
