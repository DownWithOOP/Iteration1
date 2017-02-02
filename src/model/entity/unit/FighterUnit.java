package model.entity.unit;
package model.common;

public class FighterUnit extends Unit {
    //private Army army;

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