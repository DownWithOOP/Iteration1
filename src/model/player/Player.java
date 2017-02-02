package model.player;

import model.actions.Action;
import model.entity.Entity;
import model.entity.army.Army;
import model.entity.structure.Structure;
import model.entity.unit.Unit;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by CRISTIAN aka Batman
 */
public class Player {

    private ArrayList<Entity> allEntities;
    private ArrayList<Unit> units;
    private ArrayList<Structure> structures;
    private ArrayList<Army> armies;

    private Entity selectedEntity;

    private HashMap<Integer, Action> actionMap;

    public Player(){

    }

    public boolean addStructure(Structure structure){
        return false;
    }

    public boolean addUnit(Unit unit){
        return false;
    }

    public boolean addArmy(Army army){
        return false;
    }

    public boolean removeStructure(){
        return false;
    }

    public boolean removeUnit(){
        return false;
    }

    public boolean removeArmy(){
        return false;
    }
}
