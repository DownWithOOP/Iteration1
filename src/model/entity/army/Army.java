package model.entity.army;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.actions.ActionModifiers;
import model.common.Location;
import model.entity.Entity;
import model.entity.Fighter;
import model.entity.stats.DefaultArmyStats;
import model.entity.stats.Stats;
import model.entity.stats.UnitStats;
import model.entity.unit.Explorer;
import model.entity.unit.FighterUnit;
import model.entity.unit.Ranged;
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


    protected final HashMap<TypeOfActions, Action> armyActions = new HashMap<>();                       //add all the Actions of an army here
    private static DefaultArmyStats initialStats = new DefaultArmyStats();
    private UnitStats armyStats = new UnitStats(initialStats.offensiveDamage, initialStats.defensiveDamage,
            initialStats.armor, initialStats.movement, initialStats.health,
            initialStats.upkeep, initialStats.visionRadius,initialStats.range);

    HashMap<UUID, FighterUnit> reinforcements = new HashMap<>();
    HashMap<UUID, FighterUnit> battleGroup = new HashMap<>();
    private RallyPoint rallyPoint;

//    private int
//    private int
//    private int
//    private int
//    private int


    public Army(Player player, Location rallyPoint) {
        super(player);
        initializeArmy();
        this.rallyPoint= new RallyPoint(rallyPoint);
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
        Stats unitStats = fighterUnit.getUnitStats();
        int attack = unitStats.getOffensiveDamage();

        int defense = unitStats.getDefensiveDamage();

        int upKeep = unitStats.getUpkeep();

        int health = unitStats.getHealth();

        if (this.playerId == fighterUnit.getPlayerId()) {
            if (rallyPoint.getLocation().equals(fighterUnit.getLocation())) {
                battleGroup.put(fighterEntityID, fighterUnit);
                setBattleGroupStats(attack, defense, health, upKeep);
            } else {
                reinforcements.put(fighterEntityID, fighterUnit);
                //TODO: send the coordinates of the rally point to the unit
            }
        }
    }

    public void removeFighter(FighterUnit fighterUnit) {
        UUID fighterEntityID = fighterUnit.getEntityID();
        Stats unitStats = fighterUnit.getUnitStats();

        int attack = unitStats.getOffensiveDamage() * (-1);

        int defense = unitStats.getDefensiveDamage() * (-1);

        int upKeep = unitStats.getUpkeep() * (-1);

        int health = unitStats.getHealth() * (-1);

        if (battleGroup.containsKey(fighterEntityID)) {
            battleGroup.remove(fighterEntityID);
            setBattleGroupStats(attack, defense, health, upKeep);

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

    private void setBattleGroupStats(int attack, int defense, int health, int upkeep) {
        setBattleGroupAttackPower(attack);
        setBattleGroupDefensePower(defense);
        setBattleGroupMovementSpeed();
        setBattleGroupHealth(health);
        setBattleGroupUpkeep(upkeep);
        setBattleGroupVisionRadius();
    }

    private void setBattleGroupUpkeep(int upkeep) {
        int currentUpkeep = armyStats.getUpkeep();
        currentUpkeep += upkeep;
        armyStats.setUpkeep(currentUpkeep + upkeep);
    }

    private void setBattleGroupAttackPower(int offensiveDmg) {
        int currentAttackPower = armyStats.getOffensiveDamage();
        currentAttackPower += offensiveDmg;
        armyStats.setOffensiveDamage(currentAttackPower);
    }

    private void setBattleGroupDefensePower(int defensiveDmg) {
        int currentDefensivePower = armyStats.getDefensiveDamage();
        currentDefensivePower += defensiveDmg;
        armyStats.setDefensiveDamage(currentDefensivePower);
    }

    private void setBattleGroupHealth(int health) {
        int currentHealth = armyStats.getHealth();
        currentHealth += health;
        armyStats.setHealth(currentHealth);
    }

    private void setBattleGroupMovementSpeed() {
        int slowestSpeed = Integer.MAX_VALUE;
        for (FighterUnit fighterUnit :
                battleGroup.values()) {
            int temp = fighterUnit.getUnitStats().getMovement();
            if (temp < slowestSpeed) {
                armyStats.setMovement(temp);
            }
        }
        if (battleGroup.isEmpty()){
            armyStats.setMovement(0);
        }
    }

    private void setBattleGroupVisionRadius() {
        int currentVisionRadius = 0;
        for (FighterUnit fighterUnit :
                battleGroup.values()) {
            int temp = fighterUnit.getUnitStats().getVisionRadius();
            if (temp > currentVisionRadius) {
                armyStats.setMovement(temp);
            }
        }
        if (battleGroup.isEmpty()){
            armyStats.setVisionRadius(0);
        }
    }

    private void setBattleGroupAttackRange(){

    }

//    private int checkResourceLevel() {
//
//        return 5;
//    }
//
//    private void canActionBePerformed() {
//
//    }

    private void changeReinforcementsTargetLocation() {

    }

    private void moveBattleGroup() {

    }

    public void arrivedRallyPoint(FighterUnit fighterUnit){
        if (this.playerId == fighterUnit.getPlayerId()) {
            reinforcements.remove(fighterUnit.getEntityID());
            reinforcements.put(fighterUnit.getEntityID(),fighterUnit);
        }
    }


    @Override
    public boolean decommission() {
        for (FighterUnit fighterUnit:
             reinforcements.values()) {
            fighterUnit.decommission();
        }
        for (FighterUnit fighterUnit:
             battleGroup.values()) {
            fighterUnit.decommission();
        }
        return true;
    }

    @Override
    public void attack() {

    }

    @Override
    public void defend() {

    }

    public void update() {

    }


    public static void main(String[] args) {
        Player play= new Player("helloWorld");
        Player playEnemy= new Player("helloWorld1");

        Explorer explorer= new Explorer(play,new Location(1,2));
        Ranged ranged= new Ranged(play,new Location(1,2));
        Ranged ranged1= new Ranged(play,new Location(2,2));
        Ranged rangedEnemy= new Ranged(playEnemy,new Location(1,2));

        Army arm= new Army(play, new Location(1,2));

        explorer.joinArmy(arm);
        ranged.joinArmy(arm);
        ranged1.joinArmy(arm);
        rangedEnemy.joinArmy(arm);
        ranged.abandonArmy();
        explorer.abandonArmy();
        ranged1.setCurrentLocation(1,2);

    }


}
