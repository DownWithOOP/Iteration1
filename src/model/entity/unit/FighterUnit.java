package model.entity.unit;

import model.entity.stats.UnitStats;
import model.common.Location;
import model.entity.army.Army;

public class FighterUnit extends Unit {
    private Army army;
    private String fighterUnitType;

    public FighterUnit(String fighterUnitType, UnitStats fighterStats) {
        super(fighterStats);
        this.fighterUnitType = fighterUnitType;
    }

    public boolean abandonArmy() {
        return true;
    }

    public boolean joinArmy() {
        return true;
    }

    @Override
    public boolean moveUnit(int x, int y) {
        this.setCurrentLocation(x,y);
        return true;
    }

    @Override
    public Location getLocation() {
        return getCurrentLocation();
    }

    public String getFighterUnitType() {
        return fighterUnitType;
    }
}