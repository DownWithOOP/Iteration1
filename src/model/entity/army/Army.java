package model.entity.army;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.actions.ActionModifiers;
import model.common.Location;
import model.entity.Entity;
import model.entity.Fighter;
import model.entity.unit.FighterUnit;
import model.player.Player;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by jordi on 2/2/2017.
 */

//TODO: vision radius ask about why the base should know about the vision Radius
public class Army extends Entity implements Fighter {


    //add all the Actions of an army here
    protected final HashMap<TypeOfActions, Action> armyActions = new HashMap<>();

    private int visionRadius;
    HashMap<UUID, FighterUnit> reinforcements = new HashMap<>();
    HashMap<UUID, FighterUnit> battleGroup = new HashMap<>();
    //TODO: tell the Entity class to enforce the passing of the player ID


    private int totalMovement;
    private int batteGroupTotalAttack;
    private int batteGroupTotalDefense;
    private RallyPoint rallyPoint;

    //TODO:check for resource levels before performing an action
    private int totalResourceConsumption;
    private int battleGroupAttackRange = 0;
//    private int
//    private int
//    private int
//    private int
//    private int


    public Army(Player player) {
        super(player);
        initializeArmy();
    }

    protected void initializeArmy() {
        setArmyActions();
        addAllActions(armyActions);
    }

    protected void setArmyActions() {

    }

    @Override
    public Location getLocation() {
        return null;
    }


    public void disbandArmy() {
        for (FighterUnit fighterUnit :
                reinforcements.values()) {
            fighterUnit.abandonArmy();
        }
        for (FighterUnit fighterUnit :
                battleGroup.values()) {
            fighterUnit.abandonArmy();
        }
    }

    public void registerFighter(FighterUnit fighterUnit) {
        UUID fighterEntityID = fighterUnit.getEntityID();

        if (this.playerId == fighterUnit.getPlayerId()) {
            if (rallyPoint.getLocation().equals(fighterUnit.getLocation())) {
                battleGroup.put(fighterEntityID, fighterUnit);
            } else {
                reinforcements.put(fighterEntityID, fighterUnit);
                //TODO: send the coordinates of the rally point to the unit
                //TODO: attack and defense needed form the fighterUnit
            }
        }
    }

    public void removeFighter(FighterUnit fighterUnit) {
        UUID fighterEntityID = fighterUnit.getEntityID();
        //TODO: get attack and defense, resource consumption,range of the fighterUnit
        if (battleGroup.containsKey(fighterEntityID)) {
            battleGroup.remove(fighterEntityID);
        }
        if (reinforcements.containsKey(fighterEntityID)) {
            reinforcements.remove(fighterEntityID);
        }

    }

    public void notifyBattleGroup() {

    }

    public void armyWait() {

    }

    public boolean moveRallyPoint(ActionModifiers actionModifiers) {
//      TODO:HERE I AM TOMORROW CONTINUE
        boolean checkIfInvalidMovement = rallyPoint.moveRallyPoint(actionModifiers);

        return checkIfInvalidMovement;
    }

    private void setTotalResourceConsumption() {

    }

    private void setBattleGroupAttackPower() {

    }

    private void setBattleGroupDefensePower() {

    }

    private void setBattleGroupMovementSpeed() {

    }

    private int checkResourceLevel() {

        return 5;
    }

    private void canActionBePerformed() {

    }

    private void changeReinforcementsTargetLocation() {

    }

    private void moveBattleGroup() {

    }

    private void updateRange(int range) {
        if (battleGroupAttackRange >= range) {
            for (FighterUnit fighterUnit :
                    battleGroup.values()) {
//           TODO: ONCE THIS FUNCTION IS AVAILABLE UNCOMMENT
//     fighterUnit.getRange();
            }
        }
    }

    @Override
    public boolean decommission() {

        return true;
    }

    @Override
    public void attack() {

    }

    @Override
    public void defend() {

    }

    public void update(){

    }
}
