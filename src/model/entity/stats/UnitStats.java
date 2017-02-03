package model.entity.stats;

public class UnitStats extends Stats {

    // The amount of tiles on any side that an entity can see
    private int visionRadius;

    public UnitStats(int offensiveDamage, int defensiveDamage, int armor, int movement, int health, int upkeep, int visionRadius) {
        super(offensiveDamage, defensiveDamage, armor, movement, health, upkeep);
        this.visionRadius = visionRadius;
    }

    public int getVisionRadius() {
        return visionRadius;
    }

    public void setVisionRadius(int visionRadius) {
        this.visionRadius = visionRadius;
    }
}