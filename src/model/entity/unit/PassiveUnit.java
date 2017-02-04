package model.entity.unit;

import model.common.Location;
import model.entity.stats.UnitStats;
import model.player.Player;

public class PassiveUnit extends Unit {

    public PassiveUnit(UnitStats passiveStats, Player player) {
        super (passiveStats,player);
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