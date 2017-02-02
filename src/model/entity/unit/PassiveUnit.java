package model.entity.unit;

import model.common.Location;


public class PassiveUnit extends Unit {

    public PassiveUnit() {}

    @Override
    public boolean moveUnit(Location targetLocation) {
        return false;
    }
}