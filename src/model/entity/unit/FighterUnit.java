package model.entity.unit;
import model.common.Location;
import model.entity.army.Army;

public class FighterUnit extends Unit {
    private Army army;

    public FighterUnit() {

    }

    public boolean abandonArmy() {
        return true;
    }

    public boolean joinArmy() {
        return true;
    }

    public boolean moveUnit(Location location) {
        return true;
    }
}