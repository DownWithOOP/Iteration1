package model.entity.unit;

import model.entity.stats.UnitStats;

public class Ranged extends FighterUnit {

    public Ranged() {
        super (new UnitStats(10, 3, 3, 3, 100, 3, 3));
    }
}