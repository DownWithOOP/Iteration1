package model.entity.unit;

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
}