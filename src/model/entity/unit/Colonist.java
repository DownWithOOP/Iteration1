package model.entity.unit;

import model.entity.stats.UnitStats;
import model.entity.structure.Base;

public class Colonist extends FighterUnit {

    public Colonist() {
        super("Colonist", new UnitStats(2, 1, 0, 3, 50, 1, 5));
    }


//    public Base buildStructure(int rowPosition, int columnPosition) {
//        return new Base(new structureStats(),rowPosition, columnPosition);
//    }

}