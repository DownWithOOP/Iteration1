package model.player;


import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.actions.ContainsActions;
import model.common.Location;
import model.entity.Entity;
import model.entity.army.Army;
import model.entity.structure.Structure;
import model.entity.unit.*;
import utilities.EntityList;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by CRISTIAN aka Batman
 */

public class Player extends ContainsActions {

    /**
     * Max numbers
     */
    private final int MAX_STRUCTURES = 10;
    private final int MAX_ARMIES     = 10;
    private final int MAX_UNITS      = 25;
    private final int MAX_COLONISTS  = 10;
    private final int MAX_EXPLORERS  = 10;
    private final int MAX_MELEE     = 10;
    private final int MAX_RANGED     = 10;

    /**
     * Attributes
     */
    private String playerId;
    private EntityList<Entity> allEntities;
    private ArrayList<Unit> units;
    private ArrayList<Structure> structures;
    private ArrayList<Army> armies;

    private Entity selectedEntity;

    private HashMap<Integer, Action> actionMap;

    /**
     * Resource levels
     */
    private int catfoodLevel;
    private int crystalLevel;
    private int researchLevel;

    /*TODO:Set player id*/
    public Player(String playerId){
        allEntities = new EntityList<Entity>();
        units       = new ArrayList<Unit>();
        structures  = new ArrayList<Structure>();
        armies      = new ArrayList<Army>();
        actionMap   = new HashMap<Integer, Action>();

        //Each player starts the game with 2 Explorers and 1 Colonist
        units.add(new Explorer(this, new Location(0,0)));
        units.add(new Explorer(this,new Location(0,0)));
        units.add(new Colonist(this,new Location(0,0)));
        this.playerId = playerId;
    }

    /**
     * Action related methods
     */
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

    /**
     * Methods for adding and removing entities
     */
    public boolean addStructure(Structure structure){
        if (structures.size() < MAX_STRUCTURES) {
            return structures.add(structure) && allEntities.add(structure);
        }
        return false;
    }

    public boolean addUnit(Unit unit){
        if (units.size() < MAX_UNITS) {
            switch(unit.getEntityID().getEntityType()){
                case "COLONIST":
                    if(allEntities.numColonists() >= MAX_COLONISTS)
                        return false;
                    break;
                case "EXPLORER":
                    if(allEntities.numExplorers() >= MAX_EXPLORERS)
                        return false;
                    break;
                case "MELEE":
                    if(allEntities.numMelee() >= MAX_MELEE)
                        return false;
                    break;
                case "RANGED":
                    if(allEntities.numRanged() >= MAX_RANGED)
                        return false;
                    break;
                default:
                    return false;
            }
            return units.add(unit) && allEntities.add(unit);
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
        return structures.remove(structure) && allEntities.remove(structure);
    }

    public boolean removeUnit(Unit unit){
        return units.remove(unit) && allEntities.remove(unit);
    }

    public boolean removeArmy(Army army){
        return armies.remove(army) && allEntities.remove(army);

    }

    /**
     * Getters
     */
    public String getPlayerId(){
        return playerId;
    }

    public EntityList<Entity> getAllEntities() {
        return allEntities;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public ArrayList<Structure> getStructures() {
        return structures;
    }

    public ArrayList<Army> getArmies() {
        return armies;
    }

    public Entity getSelectedEntity() {
        return selectedEntity;
    }

    public int catfoodResourceLevel(){
        return catfoodLevel;
    }

    public int crystalResourceLevel(){
        return crystalLevel;
    }

    public int researchResourceLevel(){
        return researchLevel;
    }

    /**
     * Setters
     */
    public void setCatfoodResourceLevel(int level){
        this.catfoodLevel = level;
    }

    public void setCrystalResourceLevel(int level){
        this.crystalLevel = level;
    }

    public void setResearchResourceLevel(int level){
        this.researchLevel = level;
    }
}
