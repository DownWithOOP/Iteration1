package src.model.entity.stats;

public class Stats {
    private int offensiveDamage;
    private int defensiveDamage;
    private int armor;
    private int movement;
    private int health;
    private int upkeep;

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

