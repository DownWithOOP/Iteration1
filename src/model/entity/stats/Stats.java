package model.entity.stats;

public class Stats {
    private int offensiveDamage;    // damage dealt when attacking
    private int defensiveDamage;    // damage dealt when fending off an attack
    private int armor;              // absorbs a fixed amount of damage
    private int movement;           // the max distance a unit may move in one turn
    private int health;             // when reaches zero, unit is destroyed
    private int upkeep;             // resources required to keep unit at full health

    public Stats(int offensiveDamage, int defensiveDamage, int armor, int movement, int health, int upkeep) {
        this.offensiveDamage = offensiveDamage;
        this.defensiveDamage = defensiveDamage;
        this.armor = armor;
        this.movement = movement;
        this.health = health;
        this.upkeep = upkeep;
    }

    public void setOffensiveDamage(int offensiveDamage) {
        this.offensiveDamage = offensiveDamage;
    }

    public int getOffensiveDamage() {
        return offensiveDamage;
    }

    public void setDefensiveDamage(int defensiveDamage) {
        this.defensiveDamage = defensiveDamage;
    }

    public int getDefensiveDamage() {
        return defensiveDamage;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getMovement() {
        return movement;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setUpkeep(int upkeep) {
        this.upkeep = upkeep;
    }

    public int getUpkeep() {
        return upkeep;
    }
}

