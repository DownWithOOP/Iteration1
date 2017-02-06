package model.entity.stats;

public class UnitStats extends Stats {

    int range;
    private int movement;           // the max distance a unit may move in one turn

    public UnitStats(int offensiveDamage, int defensiveDamage,
                     int armor, int movement, int health,
                     int upkeep, int visionRadius, int range) {
        super(offensiveDamage, defensiveDamage, armor, health, upkeep, visionRadius);
        this.movement = movement;
        this.range=range;
        ++size;
    }
    public int getRange(){
        return this.range;
    }

    public void setRange(int range){
        this.range=range;
        this.movement = movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getMovement() {
        return movement;
    }


}