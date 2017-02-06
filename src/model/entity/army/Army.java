package model.entity.army;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.actions.ActionModifiers;
import model.common.Location;
import model.entity.Entity;
import model.entity.EntityID;
import model.entity.Fighter;
import model.entity.stats.DefaultArmyStats;
import model.entity.stats.Stats;
import model.entity.stats.UnitStats;
import model.entity.unit.EntityType;
import model.entity.unit.Explorer;
import model.entity.unit.FighterUnit;
import model.entity.unit.Ranged;
import model.map.Map;
import model.player.Player;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.lang.reflect.Modifier;
import java.util.*;

import model.entity.EntityID;

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

    HashMap<EntityID, FighterUnit> reinforcements = new HashMap<>();
    HashMap<EntityID, FighterUnit> battleGroup = new HashMap<>();
    private RallyPoint rallyPoint;
    private Queue<Location> pathqueue=new LinkedList<>();

//    private int
//    private int
//    private int
//    private int
//    private int


    public Army(Player player, Location rallyPoint) {
        super(player, EntityType.ARMY);
        initializeArmy();
        this.rallyPoint= new RallyPoint(rallyPoint,this);
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

    /**
     * Actions
     */

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
        EntityID fighterEntityID = fighterUnit.getEntityID();
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
        EntityID fighterEntityID = fighterUnit.getEntityID();
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

    public void setPathQueue(Queue<Location> queue){
        pathqueue=queue;
    }

    //TODO:IMPLEMENT THIS METHOD
    public void createArmy(){

    }

    public boolean moveRallyPoint(ActionModifiers actionModifiers) {
//      TODO:HERE I AM TOMORROW CONTINUE
        rallyPoint.moveRallyPoint(actionModifiers);

        return true;
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
//TODO: IMPLEMENT THIS METHOD, VERY IMPORTANT!!!!!!
    private void moveBattleGroup(Location nextTile) {
        for (FighterUnit fighterUnit:
             battleGroup.values()) {
            fighterUnit.moveUnitArmy(nextTile);
        }
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
        return player.removeArmy(this);
    }

    @Override
    public void attack(ActionModifiers actionModifier) {

    }

    @Override
    public void defend(ActionModifiers actionModifiers) {

    }

    public static void main(String[] args) {

        /**
         * I assume there are just for testing? player takes a boolean playermap now - Cristian
         */
        Player play= new Player("helloWorld", new Map());
        Player playEnemy= new Player("helloWorld1", new Map());

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

     public List<Entity> getWholeArmy(){
         List<Entity>reinforcements= getReinforcements();
         List<Entity>battleGroup= getBattleGroup();
         battleGroup.addAll(reinforcements);
         return battleGroup;
     }

     public List<Entity> getList(HashMap<EntityID,FighterUnit>map){
        List<Entity> temp= new ArrayList<>();
         for (Entity entity:
              map.values()) {
             temp.add(entity);
         }
       return temp;
     }

    public List<Entity> getReinforcements(){
         return getList(reinforcements);
    }
    public List<Entity> getBattleGroup(){
        return getList(battleGroup);
    }
    public List<List<Entity>> getCircleTypeList(){
        List<List<Entity>> circleTypeList= new ArrayList<>();
        circleTypeList.add(0,getWholeArmy());
        circleTypeList.add(1,getBattleGroup());
        circleTypeList.add(2,getReinforcements());

        return  circleTypeList;
    }
    public RallyPoint getRallyPoint(){
        return rallyPoint;
    }

    public UnitStats getArmyStats() {
        return armyStats;
    }

    @Override
    public void executeCommand(){
        if (!pathqueue.isEmpty()){
            moveArmy();
        }
    }

    private void moveArmy(){
        for (int i=0; i<armyStats.getMovement(); i++) {
             Location tempLocation = pathqueue.poll();
            moveBattleGroup(tempLocation);
        }

    }


}
