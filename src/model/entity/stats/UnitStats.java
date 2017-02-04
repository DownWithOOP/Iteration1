package model.entity.stats;

public class UnitStats extends Stats {
    private int movement;           // the max distance a unit may move in one turn

    public UnitStats(int offensiveDamage, int defensiveDamage, int armor, int movement, int health,
                     int upkeep, int visionRadius) {
        super(offensiveDamage, defensiveDamage, armor, movement, health, upkeep, visionRadius);
        this.movement = movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getMovement() {
        return movement;
    }

}