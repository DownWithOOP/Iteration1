package model.entity;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.actions.ActionModifiers;
import model.actions.ContainsActions;
import model.actions.playerActions.EntityAction;
import model.common.Location;
import model.player.Player;
import model.entity.EntityID;
import model.entity.unit.EntityType;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.UUID;

abstract public class Entity extends ContainsActions {

    protected Player player;
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
        //if the currentAction turn tracker is 0, execute and pop another action from the queue, else
        //decrement currentAction

        if (currentAction == null){
            pollAction();
        }

        if(currentActionTurnTracker == 0 && currentAction != null){
            currentAction.execute();
            currentAction = null;
            pollAction();
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

    public boolean addToQueue(Action action) {
        return commandQueue.add((EntityAction) action);
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

    public boolean powerUp() {
        return true;
    }

    public boolean powerDown() {
        return true;
    }

    //do we need this method?
    public void changeStat(int stat, int statOffset) {

    }

    public EntityID getEntityID() {
        return entityID;
    }

    public String getPlayerId() {
        return player.getPlayerId();
    }

    public EntityType getEntityType(){
        return entityType;
    }

    @Override
    public void resume(){
        addAvailableActions();
    }

    @Override
    public void leave(){
        removeAvailableActions();
    }


}