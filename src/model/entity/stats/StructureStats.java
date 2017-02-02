package model.entity.stats;

public class StructureStats extends Stats {

    private int productionRates;    // the # of turns required to produce a unit of a specific type

    public StructureStats(int offensiveDamage, int defensiveDamage, int armor, int movement, int health, int upkeep, int productionRates) {
        super(offensiveDamage, defensiveDamage, armor, movement, health, upkeep);
        this.productionRates = productionRates;
    }

    public void setProductionRates(int productionRates) {
        this.productionRates = productionRates;
    }

    public int getProductionRates() {
        return productionRates;
    }
}