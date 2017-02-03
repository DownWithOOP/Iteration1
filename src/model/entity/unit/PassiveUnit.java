package model.entity.unit;

import model.common.Location;
import model.entity.stats.UnitStats;

public class PassiveUnit extends Unit {

    public PassiveUnit(UnitStats passiveStats) {
        super (passiveStats);
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
}