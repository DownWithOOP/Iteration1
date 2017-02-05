package model.entity;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.actions.ContainsActions;
import model.common.Location;
import model.player.Player;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.UUID;

abstract public class Entity extends ContainsActions {


    protected Player player;
    protected String playerId;
    private UUID entityID;                                                                      // Unique ID for each created Entity
    private Queue<Action> commandQueue;                                                          // Queue of user selected commands for each entity to perform in a # of turns
    protected final HashMap<TypeOfActions, Action> entityActions = new HashMap<>();                //add all the Actions of an entity here

//TODO: we need player to get the PlayerResources of the player and see if we can perform an action
    public Entity(Player player) {
        entityID = UUID.randomUUID();
        commandQueue = new LinkedList<Action>();
        initializeEntity();
        this.player = player;
        playerId=getPlayerId();
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

    public UUID getEntityID() {
        return entityID;
    }

    @Override
    protected void addAvailableActions() {

    }

    @Override
    protected void removeAvailableActions() {

    }

    public String getPlayerId() {
        return player.getPlayerId();
    }


}