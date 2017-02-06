package model.player;

import model.actions.ActionModifiers;
import model.common.Location;
import model.entity.Entity;
import model.entity.army.Army;
import model.entity.army.RallyPoint;
import model.entity.stats.StructureStats;
import model.entity.structure.Base;
import model.entity.structure.Structure;
import model.entity.unit.EntityType;
import model.entity.unit.Explorer;
import model.entity.unit.Melee;
import model.entity.unit.Unit;
import model.map.Map;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordi on 2/5/2017.
 */
public class ComplexDataStructure {
    List<List<Entity>> unitList;          //Ranged=0, Melee=1, Colonist=2, Explorer=3
    List<Army> armyList;          //Whole=0, Battle=1, Reinf=2
    List<List<Entity>> structureList;         //base=0
    List<List<Entity>> currentMode;
    List<RallyPoint> rallyPointList = new ArrayList<>();
    RallyPoint selectedRallyPoint=null;
    EntityType modeHolders[]={EntityType.UNIT,EntityType.STRUCTURE,EntityType.ARMY,EntityType.RALLYPOINT};

    int typeRestriction = 10;
    int unitCap = 25;
    private Army selectedArmy = null;
    private final int rangedIndex = 0;
    private final int meleeIndex = 1;
    private final int colonistIndex = 2;
    private final int explorerIndex = 3;
    private final int unitTypeNumber = 5;
    private final int structureTypeNumber = 1;


    ComplexDataStructure() {
        unitList = new ArrayList<>(5);
        armyList = new ArrayList<>(10);
        structureList = new ArrayList<>(1);
        rallyPointList= new ArrayList<>(20);
        initializeLists();
        changeMode(modeHolders[0]);
    }

    private void initializeLists() {
        for (int i = 0; i < unitTypeNumber; i++) {
            unitList.add(new ArrayList<>());
        }
        for (int i = 0; i < structureTypeNumber; i++) {
            structureList.add(new ArrayList<>());
        }

    }

    public boolean addEntity(Entity entity) {
        EntityType entityType = entity.getEntityID().getEntityType(0);
        boolean returnValue = false;
        if (entityType == EntityType.ARMY) {

            if (armyList.size() < typeRestriction && !armyList.contains(entity)) {
                armyList.add(((Army) entity));
                RallyPoint tempR=((Army) entity).getRallyPoint();
                rallyPointList.add(tempR);
                return true;
            }
            return false;
            //TODO HANDLE ARMY LATER
        }
        returnValue = addStructure(entityType, entity);
        if (returnValue == false) {
            returnValue = addUnit(entityType, entity);
        }
        return returnValue;
    }

    public boolean addStructure(EntityType entityType, Entity entity) {
        boolean result = false;
        switch (entityType) {
            case BASE:
                result = addToIndex(structureList, 0, entity);
                break;
        }
        return result;
    }


    private boolean addToIndex(List<List<Entity>> entityList, int index, Entity entity) {
        if (entityList.get(index).isEmpty() || entityList.get(index).size() < typeRestriction && !entityList.get(index).contains(entity)) {
            entityList.get(index).add(entity);
            return true;
        }
        return false;
    }

    private boolean addUnit(EntityType entityType, Entity entity) {
        int totalSize = 0;
        boolean returnValue = false;
        for (int i = 0; i < unitList.size(); i++) {
            totalSize += unitList.get(i).size();
        }
        if (totalSize < unitCap) {

            switch (entityType) {
                case COLONIST:
                    returnValue = addToIndex(unitList, colonistIndex, entity);
                    break;
                case EXPLORER:
                    returnValue = addToIndex(unitList, explorerIndex, entity);
                    break;
                case MELEE:
                    returnValue = addToIndex(unitList, meleeIndex, entity);
                    break;
                case RANGED:
                    returnValue = addToIndex(unitList, rangedIndex, entity);
                    break;
            }
        }
        return returnValue;
    }


    public static int next(int size, int index) {
        index++;
        index %= size;

        return index;
    }

    public static int previous(int size, int index) {
        index--;
        if (index < 0) {
            index = size - 1;
        }
        return index;
    }

    int circleTypeIndex = 0;
    int circleInstancesIndex = 0;
    int selectedArmyIndex = 0;
    int circleModeIndex=0;
    public Entity circleType(ArrayAction arrayAction) {
        circleInstancesIndex = 0;
        Entity temp = null;
        if (currentMode == null) {
            return null;
        }
        if (arrayAction == ArrayAction.increment) {
            temp=incrementType();
        }
        if (arrayAction == ArrayAction.decrement) {
            temp=decrementType();
        }
        return temp;
    }

    private Entity incrementType() {
        int i = circleTypeIndex + 1;
        int listSize = currentMode.size();
        while (i != circleTypeIndex) {
            if (i >= listSize) {
                i %= listSize;
            }
            if (!currentMode.get(i).isEmpty()) {
                circleTypeIndex = i;
                return currentMode.get(circleTypeIndex).get(circleInstancesIndex);
            }
            i++;
        }
        return null;
    }
    private Entity decrementType() {
        int i = circleTypeIndex - 1;
        int listSize = currentMode.size();
        while (i != circleTypeIndex) {
            if (i < 0) {
                i=listSize-1;
            }
            if (!currentMode.get(i).isEmpty()) {
                circleTypeIndex = i;
                return currentMode.get(circleTypeIndex).get(circleInstancesIndex);
            }
            i--;
        }
        return null;
    }


    public Entity circleInstances(ArrayAction arrayAction) {

        if (currentMode == null) {
            return null;
        }
        if (arrayAction == ArrayAction.increment) {
            circleInstancesIndex = next(currentMode.get(circleTypeIndex).size(), circleInstancesIndex);
        }
        if (arrayAction == ArrayAction.decrement) {
            circleInstancesIndex = previous(currentMode.get(circleTypeIndex).size(), circleInstancesIndex);
        }
        return currentMode.get(circleTypeIndex).get(circleInstancesIndex);
    }

    public RallyPoint circleInstancesRallyPoint(ArrayAction arrayAction){
        if (rallyPointList == null) {
            return null;
        }
        if (arrayAction == ArrayAction.increment) {
            circleInstancesIndex = next(rallyPointList.size(),circleInstancesIndex);
        }
        if (arrayAction == ArrayAction.decrement) {
            circleInstancesIndex = previous(rallyPointList.size(), circleInstancesIndex);
        }
        return rallyPointList.get(circleInstancesIndex);

    }

    public Entity circleMode(ArrayAction arrayAction){
        if (arrayAction==ArrayAction.increment){
            circleModeIndex=next(modeHolders.length,circleModeIndex);
        }
        if (arrayAction==ArrayAction.decrement){
            circleModeIndex=previous(modeHolders.length,circleModeIndex);
        }
        return changeMode(modeHolders[circleModeIndex]);
    }

    private Entity changeMode(EntityType entityType) {
        resetIndexes();
        switch (entityType) {
            case ARMY:
                selectedArmy = armyList.get(selectedArmyIndex);
                if (selectedArmy != null) {
                    currentMode = selectedArmy.getCircleTypeList();
                }
                selectedRallyPoint=null;
                break;
            case UNIT:
                currentMode = unitList;
                selectedRallyPoint= null;
                break;
            case STRUCTURE:
                currentMode = structureList;
                selectedRallyPoint=null;
                break;
            case RALLYPOINT:
                selectedRallyPoint=rallyPointList.get(0);
                currentMode=null;
                break;
        }
        return defineEntityReturned();
    }

    public Entity switchArmy(ActionModifiers actionModifier) {
        if (selectedArmy != null) {
            if (actionModifier.getValue() >= 0 && armyList.size() > actionModifier.getValue() + 1) {
                selectedArmy = armyList.get(actionModifier.getValue());
                currentMode = selectedArmy.getCircleTypeList();
                resetIndexes();
            }
        }

        return defineEntityReturned();
    }

    public RallyPoint getRallypoint(){
        return selectedRallyPoint;
    }
    private Entity defineEntityReturned() {
        if (currentMode != null &&!currentMode.isEmpty()) {
            for (int i = 0; i < currentMode.size(); i++) {
                if (!currentMode.get(i).isEmpty()) {
                    circleTypeIndex = i;
                    return currentMode.get(circleTypeIndex).get(circleInstancesIndex);
                }
            }
        }
        return null;
    }

    private void resetIndexes() {
        selectedArmyIndex = 0;
        circleTypeIndex = 0;
        circleInstancesIndex = 0;
    }

    public void removeEntity(Entity entity){
        EntityType entityType= entity.getEntityID().getEntityType(0);
        switch (entityType){
            case ARMY:
                armyList.remove(entity);
                rallyPointList.remove(((Army)entity).getRallyPoint());
                break;
            case BASE:
                structureList.get(0).remove(entity);
                break;
            case RANGED:
                unitList.get(rangedIndex).remove(entity);
                break;
            case COLONIST:
                unitList.get(colonistIndex).remove(entity);
                break;
            case EXPLORER:
                unitList.get(explorerIndex).remove(entity);
                break;
            case MELEE:
                unitList.get(meleeIndex).remove(entity);
                break;
        }
    }

    public List<Unit> getUnit(){
        List<Unit> renderList= new ArrayList<>();
        for (List<Entity> list:
                unitList) {
            for (Entity ent:
                    list) {
                Unit temp=(Unit)ent;
                renderList.add(temp);
            }
        }
        return renderList;
    }

    public List<Structure> getStructure(){
        List<Structure> renderList= new ArrayList<>();
        for (List<Entity> list:
                structureList) {
            for (Entity ent:
                    list) {
                Structure temp=(Structure)ent;
                renderList.add(temp);
            }
        }
        return renderList;
    }

    public List<Army> getArmy(){
        return armyList;
    }


    public static void main(String[] args) {
        ComplexDataStructure complexDataStructure = new ComplexDataStructure();
        Army army = new Army(new Player("hello", new Map()), new Location(1, 2));
        Army army1 = new Army(new Player("world", new Map()), new Location(3, 2));
        Melee melee = new Melee(new Player("hello", new Map()), new Location(1, 2));
        Melee melee1 = new Melee(new Player("hello", new Map()), new Location(1, 2));
        Melee melee2 = new Melee(new Player("hello", new Map()), new Location(1, 2));
        Melee melee3 = new Melee(new Player("hello", new Map()), new Location(1, 2));
        Melee melee4 = new Melee(new Player("hello", new Map()), new Location(1, 2));
        Explorer explorer1 = new Explorer(new Player("hello", new Map()), new Location(1, 2));
        melee.joinArmy(army);
        melee1.joinArmy(army);
        melee2.joinArmy(army);
        Base base = new Base(new StructureStats(5, 5, 5, 5, 5, 5, 5), new Location(3, 1), new Player("hello", new Map()));

        boolean check = false;
        check = complexDataStructure.addEntity(explorer1);
        check = complexDataStructure.addEntity(melee);
        check = complexDataStructure.addEntity(melee1);
        check = complexDataStructure.addEntity(melee2);
        check = complexDataStructure.addEntity(melee3);
        check = complexDataStructure.addEntity(melee4);
        check = complexDataStructure.addEntity(army);
        check = complexDataStructure.addEntity(army1);
        check = complexDataStructure.addEntity(base);

        Entity entity = complexDataStructure.changeMode(EntityType.ARMY);
        Entity entity1 = complexDataStructure.changeMode(EntityType.UNIT);
        Melee entity2 = (Melee) complexDataStructure.circleInstances(ArrayAction.increment);
        entity2 = (Melee) complexDataStructure.circleInstances(ArrayAction.increment);
        entity2 = (Melee) complexDataStructure.circleInstances(ArrayAction.increment);
        entity2 = (Melee) complexDataStructure.circleInstances(ArrayAction.decrement);
        entity = complexDataStructure.changeMode(EntityType.ARMY);
        entity = complexDataStructure.circleInstances(ArrayAction.increment);
        entity = complexDataStructure.circleInstances(ArrayAction.increment);
        entity = complexDataStructure.circleInstances(ArrayAction.increment);
        entity = complexDataStructure.circleInstances(ArrayAction.decrement);
        entity = complexDataStructure.circleInstances(ArrayAction.increment);
        entity = complexDataStructure.changeMode(EntityType.UNIT);

        entity1 = complexDataStructure.circleType(ArrayAction.decrement);
        entity = complexDataStructure.circleType(ArrayAction.increment);

        complexDataStructure.removeEntity(melee);

        Entity enti3 = complexDataStructure.changeMode(EntityType.STRUCTURE);

        complexDataStructure.switchArmy(ActionModifiers.one);
    }

}
