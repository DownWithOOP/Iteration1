package model.entity.unit;

import model.entity.stats.UnitStats;

public class Melee extends FighterUnit {

    public Melee() {
        super(new UnitStats(20, 3, 5, 2, 100, 3, 1));
    }
}