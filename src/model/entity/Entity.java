package model.entity;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.actions.ContainsActions;
import model.common.Location;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.UUID;

abstract public class Entity extends ContainsActions {
    // Unique ID for each created Entity
    private UUID entityID;

    // Queue of user selected commands for each entity to perform in a # of turns
    private Queue<Action> commandQueue;

    //add all the Actions of an entity here
    protected final HashMap<TypeOfActions,Action> entityActions= new HashMap<>();


    public Entity() {
        entityID = UUID.randomUUID();
        commandQueue = new LinkedList<Action>();
        this.initialize();
    }


    @Override
    protected void initialize() {
        setActions();
        addAllActions(entityActions);
    }


    @Override
    protected void setActions(){
        /**
         *         entityActions.put(TypeOfActions.powerUp,PowerUpAction(this));
         * */
    }

    abstract public Location getLocation();

    public boolean decommission() {
        return true;
    }

    public boolean addToQueue(Action action) {
        if (commandQueue.add(action) == true) {
            return true;
        }
        return false;   // adding command to queue was not successful
    }

    public boolean cancelQueue() {
        while (!commandQueue.isEmpty()) {
            commandQueue.poll();
        }
        return true;   // canceling queue command wasn't successful
    }

    public boolean powerUp() {
        return true;
    }

    public boolean powerDown() {
        return true;
    }

    //do we need this method?
    public void changeStat(int stat, int statOffset) {

    }

    public void setEntityID(UUID entityID) {
        this.entityID = entityID;
    }

    public UUID getEntityID() {
        return entityID;
    }

    @Override
    protected void addAvailableActions(){

    }
    @Override
    protected void removeAvailableActions(){

    }


}