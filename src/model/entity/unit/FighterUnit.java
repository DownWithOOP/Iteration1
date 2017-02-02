package model.entity.unit;

import model.common.Location;
import model.entity.army.Army;

public class FighterUnit extends Unit {
    private Army army;

    public FighterUnit() {

    }

    @Override
    public boolean moveUnit(Location targetLocation) {
        return false;
    }

    public boolean abandonArmy() {
        return true;
    }

    public boolean joinArmy() {
        return true;
    }
}