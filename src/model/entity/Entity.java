package model.entity;
//import model.entity.stats.Stats;
import model.actions.Action;
import model.common.Location;

import java.util.Queue;
import java.util.LinkedList;
import java.util.UUID;

abstract public class Entity {
    // Unique ID for each created Entity
    private UUID entityID;

    // Queue of user selected commands for each entity to perform in a # of turns
    private Queue<Action> commandQueue;

    private int visionRadius;

    public Entity(int visionRadius) {
        entityID = UUID.randomUUID();
        commandQueue = new LinkedList<Action>();
        this.visionRadius = visionRadius;
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

}