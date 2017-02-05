package model.entity.army;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.actions.ActionModifiers;
import model.actions.ContainsActions;
import model.actions.armyRallyPointActions.MoveRallyPointAction;
import model.common.Location;
import model.map.Map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jordi on 2/4/2017.
 */
public class RallyPoint extends ContainsActions {
    private Location currentLocation;
    //TODO: PASS THE MAP OF THE PLAYER
    Map map = new Map();
    Army army;
    Queue<Location> pathQueue = new LinkedList<>();
    protected final HashMap<TypeOfActions, Action> rallyPointActions = new HashMap<>();                //add all the Actions of an RallyPoint here


    public RallyPoint(Location location, Army army) {
        initializeRallyPoint();
        this.currentLocation = location;
        this.army = army;
    }

    public Location getLocation() {
        return currentLocation;
    }

//    public void changeLocation(Location location) {
//        this.location = location;
//    }

    public void moveRallyPoint(ActionModifiers actionModifiers) {
        int xCoordinate = currentLocation.getxCoord();
        int yCoordinate = currentLocation.getyCoord();
        int previousX = xCoordinate;

        if (actionModifiers.equals(ActionModifiers.up)) {
            yCoordinate--;
        }
        if (actionModifiers.equals(ActionModifiers.down)) {
            yCoordinate++;
        }
        if (actionModifiers.equals(ActionModifiers.right)) {
            xCoordinate++;
        }
        if (actionModifiers.equals(ActionModifiers.left)) {
            xCoordinate--;
        }

        if (!map.getTile(xCoordinate, yCoordinate).isPassable()) {
            return;
        }

        Location nextLocation= new Location(xCoordinate,yCoordinate);

        if (!pathQueue.isEmpty()) {
            if (!pathQueue.peek().equals(nextLocation)) {
                pathQueue.add(nextLocation);
            }
        }else{
            pathQueue.add(nextLocation);
        }

        if (xCoordinate != previousX) {
            currentLocation.setxCoord(xCoordinate);
        } else {
            currentLocation.setyCoord(yCoordinate);
        }
    }


    @Override
    public void resume() {
        addAvailableActions();
    }

    @Override
    public void leave() {
        removeAvailableActions();
        emptyQueue();
    }

    protected void emptyQueue(){
        pathQueue.clear();
    }

    protected void initializeRallyPoint() {
        setEntityActions();
        addAllActions(rallyPointActions);
    }


    protected void setEntityActions() {
        rallyPointActions.put(TypeOfActions.moveRallyPoint, new MoveRallyPointAction(this));
        /**
         *         rallyPointActions.put(TypeOfActions.powerUp,PowerUpAction(this));
         * */
    }
}
