package model.player;


import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.actions.ContainsActions;
import model.entity.Entity;
import model.entity.army.Army;
import model.entity.structure.Structure;
import model.entity.unit.Explorer;
import model.entity.unit.Colonist;
import model.entity.unit.Unit;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by CRISTIAN aka Batman
 */

public class Player extends ContainsActions {

    private final int MAX_STRUCTURES = 10;
    private final int MAX_ARMIES     = 10;
    private final int MAX_UNITS      = 25;
    private final int MAX_COLONISTS  = 10;
    private final int MAX_EXPLORERS  = 10;
    private final int MAX_MELEES     = 10;
    private final int MAX_RANGED     = 10;

    private ArrayList<Entity> allEntities;
    private ArrayList<Unit> units;
    private ArrayList<Structure> structures;
    private ArrayList<Army> armies;

    private Entity selectedEntity;

    private HashMap<Integer, Action> actionMap;

    public Player(){
        allEntities = new ArrayList<Entity>();
        units       = new ArrayList<Unit>();
        structures  = new ArrayList<Structure>();
        armies      = new ArrayList<Army>();
        actionMap   = new HashMap<Integer, Action>();

        //Each player starts the game with 2 Explorers and 1 Colonist
        units.add(new Explorer());
        units.add(new Explorer());
        units.add(new Colonist());
    }

    @Override
    public HashMap<TypeOfActions, Action> getActions() {

        return null;
    }

    @Override
    public void addAvailableActions() {

    }

    @Override
    public void removeAvailableActions() {

    }


    protected void setPlayerActions() {

    }

    protected void initializePlayer() {

    }


    public boolean addStructure(Structure structure){
        if (structures.size() < MAX_STRUCTURES) {
            if (structures.add(structure) && allEntities.add(structure)) return true;
        }
        return false;
    }

    public boolean addUnit(Unit unit){
        if (units.size() < MAX_UNITS) {
            if (units.add(unit) && allEntities.add(unit)) return true;
        }
        return false;
    }

    public boolean addArmy(Army army){
        if (armies.size() < MAX_ARMIES) {
            if (armies.add(army)) return true;
        }
        return false;
    }

    public boolean removeStructure(Structure structure){
        if (structures.remove(structure) && allEntities.remove(structure)) return true;
        return false;
    }

    public boolean removeUnit(Unit unit){
        if (units.remove(unit) && allEntities.remove(structures)) return true;
        return false;
    }

    public boolean removeArmy(Army army){
        if (armies.remove(army) && allEntities.remove(army)) return true;
        return false;

    }
}
