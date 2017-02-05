package model.entity.stats;

/**
 * Created by jordi on 2/4/2017.
 */
public class DefaultArmyStats {
    public int offensiveDamage;    // damage dealt when attacking
    public int defensiveDamage;    // damage dealt when fending off an attack
    public int armor;              // absorbs a fixed amount of damage
    public int movement;           // the max distance a unit may move in one turn
    public int health;             // when reaches zero, unit is destroyed
    public int upkeep;             // resources required to keep unit at full health
    public int visionRadius;
    public int range;

    public DefaultArmyStats(){
        offensiveDamage=0;
        defensiveDamage=0;
        armor=0;
        movement=0;
        health= 0;
        upkeep=0;
        visionRadius=0;
        range=0;
    }
}
