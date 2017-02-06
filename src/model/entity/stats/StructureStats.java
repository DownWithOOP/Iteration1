package model.entity.stats;

public class StructureStats extends Stats {

    private int productionRates;    // the # of turns required to produce a unit of a specific type

    public StructureStats(int offensiveDamage, int defensiveDamage, int armor, int health, int upkeep,
                          int productionRates, int visionRadius) {
        super(offensiveDamage, defensiveDamage, armor, health, upkeep, visionRadius);
        this.statsMap.put(StatsType.PRODUCTION_RATES, productionRates);
    }

    public void setProductionRates(int productionRates) {
        this.statsMap.put(StatsType.PRODUCTION_RATES, productionRates);
    }

    public int getProductionRates() {
        return this.statsMap.get(StatsType.PRODUCTION_RATES);
    }
}