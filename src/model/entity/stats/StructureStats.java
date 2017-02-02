package src.model.entity.stats;

public class StructureStats extends Stats {
    private int productionRates;

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