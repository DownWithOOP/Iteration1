package model.entity;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.actions.ActionModifiers;
import model.actions.ContainsActions;
import model.actions.playerActions.EntityAction;
import model.common.Location;
import model.entity.unit.Explorer;
import model.map.Map;
import model.player.Player;
import model.entity.EntityID;
import model.entity.unit.EntityType;
import model.entity.stats.Stats;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.UUID;

abstract public class Entity extends ContainsActions {

    protected Player player;
    private boolean isPoweredDown;
    protected String playerId;
    private EntityID entityID;                                                                      // Unique ID for each created Entity
    private Queue<EntityAction> commandQueue;                                                          // Queue of user selected commands for each entity to perform in a # of turns
    protected final HashMap<TypeOfActions, Action> entityActions = new HashMap<>();                //add all the Actions of an entity here
    private EntityType entityType;

    private EntityAction currentAction;
    private int currentActionTurnTracker;

//TODO: we need player to get the PlayerResources of the player and see if we can perform an action
    public Entity(Player player, EntityType entityType) {
        entityID = new EntityID(entityType);
        commandQueue = new LinkedList<>();
        initializeEntity();
        this.player = player;
        playerId=getPlayerId();
        this.entityType = entityType;
        this.currentActionTurnTracker = 0;
        isPoweredDown = false;

    }


    protected void initializeEntity() {
        setEntityActions();
        addAllActions(entityActions);
    }

    protected void setEntityActions() {
        /**
         *         entityActions.put(TypeOfActions.powerUp,PowerUpAction(this));
         * */
    }

    /**
     * handles executing of commands
     * assumes this gets called once a turn
     */
    public void executeCommand(){

        if (currentAction == null){
            pollAction();
        }

        if(currentActionTurnTracker == 0 && currentAction != null){
            currentAction.execute();
            currentAction = null;
            pollAction();
            currentActionTurnTracker--;
        } else if(currentActionTurnTracker > 0) {
            currentActionTurnTracker--;
        }
    }

    /**
     * OOOH Jesus this is a little bad, basically we're assuming turns can either be integers or increments of 0.5
     * so that being said, an action that takes 1.5 turns will finish executing by the second turn, but if
     * there are two actions such as 1.5 and 2.5, the first one will finish by the second turn and the second
     * one will finish by the 4th turn.
     */
    private void pollAction(){
        if(!commandQueue.isEmpty()) {
            currentAction = commandQueue.poll();
            double numTurns = Math.ceil(currentAction.getTurns());
            //if the current action has a half turn, and the next one has half a turn, take floor of next action turn
            if(!commandQueue.isEmpty()) {
                if (numTurns != currentAction.getTurns() && Math.ceil(commandQueue.peek().getTurns()) != commandQueue.peek().getTurns()) {
                    commandQueue.peek().setTurns(Math.floor(commandQueue.peek().getTurns()));
                }
            }
            currentActionTurnTracker = (int) Math.ceil(currentAction.getTurns());
        }
    }

    abstract public Location getLocation();

    public boolean addToQueue(EntityAction action) {
        return commandQueue.add(action);
    }

    /**
     * Actions :)
     */
    public boolean cancelQueue() {
        while (!commandQueue.isEmpty()) {
            commandQueue.poll();
        }
        return true;   // canceling queue command wasn't successful, although why wouldn't it be amirite?
    }

    abstract public boolean decommission();

    public boolean powerUp(Stats entityStats) {
        if (isPoweredDown == true) {
            entityStats.setUpkeep(entityStats.getDefaultUpkeep());
            isPoweredDown = false;
            return true;
        }
        return false;
    }

    public boolean powerDown(Stats entityStats) {
        if (isPoweredDown == false) {
            int upkeep = entityStats.getUpkeep();
            int loweredUpkeep = Math.round((int)(upkeep * .25));
            entityStats.setUpkeep(loweredUpkeep);
            isPoweredDown = true;
            return true;
        }
        return false;
    }

    //do we need this method?
    public void changeStat(int stat, int statOffset) {

    }

    @Override
    public void resume(){
        addAvailableActions();
    }

    @Override
    public void leave(){
        removeAvailableActions();
    }

    /**
     * Getters and setters
     */

    public EntityID getEntityID() {
        return entityID;
    }

    public String getPlayerId() {
        return player.getPlayerId();
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isPoweredDown() {
        return isPoweredDown;
    }

    public void setIsPoweredDown(boolean poweredDown) {
        isPoweredDown = poweredDown;
    }

    public EntityAction getCurrentAction(){
        return currentAction;
    }

}