package model.entity.stats;

public class UnitStats extends Stats {
    int range;
    public UnitStats(int offensiveDamage, int defensiveDamage, int armor, int movement, int health,
                     int upkeep, int visionRadius, int range) {
        super(offensiveDamage, defensiveDamage, armor, movement, health, upkeep, visionRadius);
        this.range=range;
    }
    public int getRange(){
        return this.range;
    }
    public void setRange(int range){
        this.range=range;
    }

}