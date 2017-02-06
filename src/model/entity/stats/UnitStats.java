package model.entity.stats;

public class UnitStats extends Stats {

    int range;
    private int movement;           // the max distance a unit may move in one turn

    public UnitStats(int offensiveDamage, int defensiveDamage,
                     int armor, int movement, int health,
                     int upkeep, int visionRadius, int range) {
        super(offensiveDamage, defensiveDamage, armor, health, upkeep, visionRadius);
        this.statsMap.put(StatsType.MOVEMENT, movement);
        this.statsMap.put(StatsType.RANGE, range);
    }
    public int getRange(){
        return statsMap.get(StatsType.RANGE);
    }

    public void setRange(int range){
        this.statsMap.put(StatsType.RANGE, range);
    }

    public void setMovement(int movement) {
        this.statsMap.put(StatsType.MOVEMENT, movement);
    }

    public int getMovement() {
        return statsMap.get(StatsType.MOVEMENT);
    }


}