package model.entity.army;

import model.common.Location;
import model.entity.Entity;

/**
 * Created by jordi on 2/2/2017.
 */

//TODO: vision radius ask about why the base should know about the vision Radius
public class Army extends Entity {
    private int visionRadius;
    //TODO: reinforcements
    //TODO: battleGroup
    //TODO: tell the Entity class to enforce the passing of the player ID

    private int playerId;
    private int totalMovement;
    private int batteGroupTotalAttack;
    private int batteGroupTotalDefense;
    private Location rallyPoint;

    //TODO:check for resource levels before performing an action
    private int totalResourceConsumption;
    private int battleGroupAttackRange;
//    private int
//    private int
//    private int
//    private int
//    private int


    public Army() {
        super();
    }

    @Override
    public Location getLocation() {
        return null;
    }

    public void disbandArmy(){

    }
    public void registerFighter(/*Fighter fighter*/){

    }
    public void removeFighter(/*Fighter fighter*/){

    }
//    public void (){
//
//    }
//    public void (){
//
//    }
//    public void (){
//
//    }
}
