package model.entity.stats;

/**
 * Created by settj on 2/1/17.
 */
interface StatsClassification{
}

 enum StatsType implements StatsClassification{
    OFFENSIVE_DAMAGE,
    DEFENSIVE_DAMAGE,
    ARMOR,
    HEALTH,
    UPKEEP,
    DEFAULT_UPKEEP,
    VISION_RADIUS;

    private final int value;

    StatsType(){
        value = ordinal();
    }

}

 enum UnitStatsType implements StatsClassification{
    MOVEMENT;

    private final int value;

    UnitStatsType(){
        value = ordinal();
    }

}

 enum StructureStatsType implements StatsClassification{
    PRODUCTION_RATES;

    private final int value;

    StructureStatsType(){
        value = ordinal();
    }

}