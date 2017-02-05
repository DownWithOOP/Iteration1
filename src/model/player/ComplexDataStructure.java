package model.player;

import model.entity.Entity;
import model.entity.army.Army;
import model.entity.structure.Base;
import model.entity.structure.Structure;
import model.entity.unit.Colonist;
import model.entity.unit.EntityType;
import model.entity.unit.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordi on 2/5/2017.
 */
public class ComplexDataStructure {
    Entity entity;
    List<List<Entity>> unitList;          //Ranged=0, Melee=1, Colonist=2, Explorer=3
    List<List<Entity>> armyList;          //Whole=0, Battle=1, Reinf=2
    List<List<Entity>> structureList;         //base=0
    List<List<Entity>> currentMode;

    ComplexDataStructure() {
        unitList = new ArrayList<>();
        armyList = new ArrayList<>();
        structureList = new ArrayList<>();
        unitList.add(new ArrayList<>());
        armyList.add(new ArrayList<>());
        structureList.add(new ArrayList<>());
        currentMode = unitList;
    }

    public void addEntity(Entity entity) {
        EntityType entityType = entity.getEntityID().getEntityType(0);
        switch (entityType) {
            case ARMY:
                //TODO: MAKE THIS ONE TOMORRow
                break;
            case BASE:
                structureList.get(0).add(entity);
                break;
            case COLONIST:
                unitList.get(2).add(entity);
                break;
            case EXPLORER:
                unitList.get(3).add(entity);
                break;
            case MELEE:
                unitList.get(1).add(entity);
                break;
            case RANGED:
                unitList.get(0).add(entity);
                break;
        }
    }

    public int next(int size, int index) {
        if (index + 1 < size) {
            index++;
        }
        return index;
    }

    public int previous(int index) {
        if (index - 1 >= 0) {
            index--;
        }
        return index;
    }

    int circleTypeIndex = 0;
    int circleInstancesIndex = 0;

    public Entity cicleType(ArrayAction arrayAction) {
        circleInstancesIndex = 0;
        if (arrayAction == ArrayAction.increment) {
            circleTypeIndex = next(currentMode.size(), circleTypeIndex);
        }
        if (arrayAction == ArrayAction.decrement) {
            circleTypeIndex = previous(circleTypeIndex);
        }
        return currentMode.get(circleTypeIndex).get(circleInstancesIndex);
    }

    public Entity circleInstances(ArrayAction arrayAction) {

        if (arrayAction == ArrayAction.increment) {
            circleInstancesIndex = next(currentMode.get(circleTypeIndex).size(), circleInstancesIndex);
        }
        if (arrayAction == ArrayAction.decrement) {
            circleInstancesIndex = previous(circleInstancesIndex);
        }
        return currentMode.get(circleTypeIndex).get(circleInstancesIndex);
    }

    public Entity changeMode(EntityType entityType) {
        circleTypeIndex = 0;
        circleInstancesIndex = 0;
        switch (entityType) {
            case ARMY:
                currentMode = armyList;
                break;
            case UNIT:
                currentMode= unitList;
                break;
            case STRUCTURE:
                currentMode = structureList;
                break;
        }
        return currentMode.get(circleTypeIndex).get(circleInstancesIndex);
    }

}
