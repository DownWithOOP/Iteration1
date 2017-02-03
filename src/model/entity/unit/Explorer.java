package model.entity.unit;

import model.entity.stats.UnitStats;

public class Explorer extends FighterUnit {

    public Explorer() {
        super(new UnitStats(2, 1, 0, 5, 50, 1, 5));
    }

    public void findResource() {

    }
}