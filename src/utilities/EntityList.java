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
            if (((Unit) e).getEntityID().getId().equals(EntityType.COLONIST.toString())) {
                numColonists++;
            } else if (((Unit) e).getEntityID().getId().equals(EntityType.EXPLORER.toString())) {
                numExplorers++;
            } else if (((Unit) e).getEntityID().getId().equals(EntityType.MELEE.toString())) {
                numMelee++;
            } else if (((Unit) e).getEntityID().getId().equals(EntityType.RANGED.toString())) {
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
                if (((Unit) o).getEntityID().getEntityType().equals(EntityType.COLONIST)) {
                    numColonists--;
                } else if (((Unit) o).getEntityID().getEntityType().equals(EntityType.EXPLORER)) {
                    numExplorers--;
                } else if (((Unit) o).getEntityID().getEntityType().equals(EntityType.MELEE)) {
                    numMelee--;
                } else if (((Unit) o).getEntityID().getEntityType().equals(EntityType.RANGED)) {
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
