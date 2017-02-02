package model.entity.unit;
import model.common.Location;
import model.entity.army.Army;

public class FighterUnit extends Unit {
    private Army army;

    public FighterUnit(int offensiveDamage, int defensiveDamage, int armor, int movement, int health, int upkeep, int visionRadius) {
        super(offensiveDamage, defensiveDamage, armor, movement, health, upkeep, visionRadius);
    }

    public boolean abandonArmy() {
        return true;
    }

    public boolean joinArmy() {
        return true;
    }

    @Override
    public boolean moveUnit(Location location) {
        return true;
    }

    @Override
    public Location getLocation() {
        return null;
    }
}