package model.entity;
package model.entity.stats;
//package src.model.common;
import java.util.Queue;

abstract public class Entity {
    private int entityID;
    private Queue<Action> commandQueue = new Queue<Action>();
    private int visionRadius; //the amount of tiles on any side that an entity can see

    public Entity(int visionRadius) {
        this.visionRadius = visionRadius;
    }

    abstract public Location getLocation();

    public boolean decommission() {
        return true;
    }

    public boolean addToQueue(Action action) {
        return true;
    }

    public boolean cancelQueue() {
        return true;
    }

    public boolean powerUp() {
        return true;
    }

    public boolean powerDown() {
        return true;
    }

    public void changeStat(int stat, int statOffset) {

    }

    public void setEntityID(int entityID) {
        this.entityID = entityID;
    }

    public int getEntityID() {
        return entityID;
    }

    public void setVisionRadius(int visionRadius) {
        this.visionRadius = visionRadius;
    }

    public int getVisionRadius() {
        return visionRadius;
    }
}