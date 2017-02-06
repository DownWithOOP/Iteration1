package model.player;


import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.actions.ActionModifiers;
import model.actions.ContainsActions;
import model.actions.playerActions.CycleCommandAction;
import model.actions.playerActions.CycleInstanceAction;
import model.actions.playerActions.CycleModeAction;
import model.actions.playerActions.CycleTypeAction;
import model.common.Location;
import model.entity.Entity;
import model.entity.army.Army;
import model.entity.army.RallyPoint;
import model.entity.structure.Structure;
import model.entity.unit.*;
import model.map.Map;
import utilities.EntityList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by CRISTIAN aka Batman
 */

public class Player extends ContainsActions {

    /**
     * Max numbers
     */
    private final int MAX_STRUCTURES = 10;
    private final int MAX_ARMIES = 10;
    private final int MAX_UNITS = 25;
    private final int MAX_COLONISTS = 10;
    private final int MAX_EXPLORERS = 10;
    private final int MAX_MELEE = 10;
    private final int MAX_RANGED = 10;

    /**
     * Attributes
     */
    private String playerId;
    private EntityList<Entity> allEntities;
    private ArrayList<Unit> units;
    private ArrayList<Structure> structures;
    private ArrayList<Army> armies;
    private ComplexDataStructure complexDataStructure = new ComplexDataStructure();
    private Entity selectedEntity = null;
    private RallyPoint selectedRallyPoint = null;

    private HashMap<Integer, Action> actionMap;
    private HashMap<TypeOfActions, Action> playerActionMap = new HashMap<>();                           // Where all the actions the player is going to perform are found

    private Map playerMap;

    /**
     * Resource levels
     */
    private int catfoodLevel;
    private int crystalLevel;
    private int researchLevel;

    public Player(String playerId, Map playerMap) {
        allEntities = new EntityList<Entity>();
        units = new ArrayList<Unit>();
        structures = new ArrayList<Structure>();
        armies = new ArrayList<Army>();
        actionMap = new HashMap<Integer, Action>();
        this.playerMap = playerMap;
        //Each player starts the game with 2 Explorers and 1 Colonist
        //TODO:CHECKOUT THESE COORDINATES
        units.add(new Explorer(this, new Location(1, 1)));
        units.add(new Explorer(this, new Location(0, 0)));
        units.add(new Colonist(this, new Location(0, 0)));
        this.playerId = playerId;
        initializePlayer();                                         /** do not delete this */
        selectedEntity = units.get(0); //TODO delet this
    }


    @Override
    public void resume() {
        addAvailableActions();
    }

    @Override
    public void leave() {
        removeAvailableActions();
    }

    protected void setPlayerActions() {
        playerActionMap.put(TypeOfActions.abandonArmy.cycleCommand, new CycleCommandAction(this));
        playerActionMap.put(TypeOfActions.abandonArmy.cycleCommand, new CycleInstanceAction(this));
        playerActionMap.put(TypeOfActions.abandonArmy.cycleCommand, new CycleModeAction(this));
        playerActionMap.put(TypeOfActions.abandonArmy.cycleCommand, new CycleTypeAction(this));
    }

    /**
     * do not touch this method
     */
    protected void initializePlayer() {
        setPlayerActions();
        addAllActions(playerActionMap);
    }

    /**
     * Methods for adding and removing entities
     */
    public boolean addStructure(Structure structure) {
        complexDataStructure.addEntity(structure);
        if (structures.size() < MAX_STRUCTURES) {
            return structures.add(structure) && allEntities.add(structure);
        }
        return false;
    }

    public boolean addUnit(Unit unit) {
        complexDataStructure.addEntity(unit);
        if (units.size() < MAX_UNITS) {
            switch (unit.getEntityID().getEntityType()) {
                case "COLONIST":
                    if (allEntities.numColonists() >= MAX_COLONISTS)
                        return false;
                    break;
                case "EXPLORER":
                    if (allEntities.numExplorers() >= MAX_EXPLORERS)
                        return false;
                    break;
                case "MELEE":
                    if (allEntities.numMelee() >= MAX_MELEE)
                        return false;
                    break;
                case "RANGED":
                    if (allEntities.numRanged() >= MAX_RANGED)
                        return false;
                    break;
                default:
                    return false;
            }
            return units.add(unit) && allEntities.add(unit);
        }
        return false;
    }

    public boolean addArmy(Army army) {
        complexDataStructure.addEntity(army);
        if (armies.size() < MAX_ARMIES) {
            if (armies.add(army)) return true;
        }
        return false;
    }

    //todo:add complexStructure remove methods
    public boolean removeStructure(Structure structure) {
        complexDataStructure.removeEntity(structure);
        return structures.remove(structure) && allEntities.remove(structure);
    }

    public boolean removeUnit(Unit unit) {
        complexDataStructure.removeEntity(unit);
        return units.remove(unit) && allEntities.remove(unit);
    }

    public boolean removeArmy(Army army) {
        complexDataStructure.removeEntity(army);
        return armies.remove(army) && allEntities.remove(army);

    }


    /**
     * Getters
     */
    public String getPlayerId() {
        return playerId;
    }

    public EntityList<Entity> getAllEntities() {
        return allEntities;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public List<Army> getArmy() {
        return complexDataStructure.getArmy();
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

    public Map getPlayerMap() {
        return playerMap;
    }

    public Location getPlayerLocation() {
        return selectedEntity.getLocation();
    }

    public int catfoodResourceLevel() {
        return catfoodLevel;
    }

    public int crystalResourceLevel() {
        return crystalLevel;
    }

    public int researchResourceLevel() {
        return researchLevel;
    }

    /**
     * Setters
     */
    public void setCatfoodResourceLevel(int level) {
        this.catfoodLevel = level;
    }

    public void setCrystalResourceLevel(int level) {
        this.crystalLevel = level;
    }

    public void setResearchResourceLevel(int level) {
        this.researchLevel = level;
    }


    public void cycleMode(ActionModifiers actionModifier) {
        ArrayAction tempArrayAction=getArrayActionUpDown(actionModifier);
        selectedEntity=complexDataStructure.circleMode(tempArrayAction);
        if (selectedEntity==null){
            selectedRallyPoint=complexDataStructure.getRallypoint();
        }
    }

    public void cycleTypes(ActionModifiers actionModifier) {
        Entity tempentity = null;
        ArrayAction tempArrayAction = getArrayActionLeftRight(actionModifier);

        if (complexDataStructure.getRallypoint() == null) {
            tempentity = complexDataStructure.circleType(tempArrayAction);
            setSelectedEntity(tempentity);
        }
    }

    public void cycleInstance(ActionModifiers actionModifier) {
        ArrayAction tempArrayAction = getArrayActionLeftRight(actionModifier);
        Entity tempEntity = null;
        RallyPoint tempRallyPoint = null;
        if (complexDataStructure.getRallypoint() == null) {

            tempEntity = complexDataStructure.circleInstances(tempArrayAction);
            setSelectedEntity(tempEntity);

        } else {
            tempRallyPoint = complexDataStructure.circleInstancesRallyPoint(tempArrayAction);
            if (tempRallyPoint != null) {
                selectedRallyPoint = tempRallyPoint;
                selectedRallyPoint.resume();
            }
        }
    }

    //TODO: ARMY TO CALL THIS, THIS IS ONLY AN ACTION ARMY CAN PERFORM
    public void switchBetweenArmies(ActionModifiers actionModifier){
        complexDataStructure.switchArmy(actionModifier);
    }

    private void setSelectedEntity(Entity tempEntity) {
        if (tempEntity != null) {
            selectedEntity = tempEntity;
            selectedEntity.resume();
        }
    }

    private ArrayAction getArrayActionLeftRight(ActionModifiers actionModifier) {
        ArrayAction temp = ArrayAction.increment;
        if (actionModifier == ActionModifiers.right) {
            temp = ArrayAction.increment;
        }
        if (actionModifier == ActionModifiers.left) {
            temp = ArrayAction.decrement;
        }
        return temp;
    }

    private ArrayAction getArrayActionUpDown(ActionModifiers actionModifier) {
        ArrayAction temp = ArrayAction.increment;
        if (actionModifier == ActionModifiers.up) {
            temp = ArrayAction.increment;
        }
        if (actionModifier == ActionModifiers.down) {
            temp = ArrayAction.decrement;
        }
        return temp;
    }

    public void setPlayerMap(Map playerMap) {
        this.playerMap = playerMap;
    }

}
