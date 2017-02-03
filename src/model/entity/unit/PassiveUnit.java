package model.entity.unit;

import model.common.Location;


public class PassiveUnit extends Unit {

    public PassiveUnit(int offensiveDamage, int defensiveDamage, int armor, int movement, int health, int upkeep, int visionRadius) {
        super(offensiveDamage, defensiveDamage, armor, movement, health, upkeep, visionRadius);
    }

    @Override
    public Location getLocation(){
        return null;
    }

    @Override
    public boolean moveUnit(Location targetLocation) {
        return false;
    }
}