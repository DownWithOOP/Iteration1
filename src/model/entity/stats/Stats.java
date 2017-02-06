package model.entity.stats;

public class Stats {
    private int offensiveDamage;    // damage dealt when attacking
    private int defensiveDamage;    // damage dealt when fending off an attack
    private int armor;              // absorbs a fixed amount of damage
    private int health;             // when reaches zero, unit is destroyed
    private int upkeep;             // resources required to keep unit at full health
    private final int defaultUpkeep;
    private int visionRadius;       // The amount of tiles on any side that an entity can see

    protected int size;

    public Stats(int offensiveDamage, int defensiveDamage, int armor, int health, int upkeep, int visionRadius) {
        size = 0;
        this.offensiveDamage = offensiveDamage;
        ++size;
        this.defensiveDamage = defensiveDamage;
        ++size;
        this.armor = armor;
        ++size;
        this.health = health;
        ++size;
        this.upkeep = upkeep;
        ++size;
        defaultUpkeep = upkeep;
        ++size;
        this.visionRadius = visionRadius;
        ++size;
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

    public int getDefaultUpkeep() { return defaultUpkeep; }

    public int getVisionRadius() {
        return visionRadius;
    }

    public void setVisionRadius(int visionRadius) {
        this.visionRadius = visionRadius;
    }

    public int getSize() {return size;}

}

