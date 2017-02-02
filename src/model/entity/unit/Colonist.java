package model.entity.unit;

import model.entity.structure.Base;

public class Colonist extends FighterUnit {

    public Colonist() {

    }

<<<<<<< HEAD
//    public Base buildStructure(int rowPosition, int columnPosition) {
//        return new Base(rowPosition, columnPosition);
//    }
=======
    public Base buildStructure(int rowPosition, int columnPosition, int visionRadius) {
        return new Base(rowPosition, columnPosition,visionRadius);
    }
>>>>>>> 55ab92aee7532f1a8f76298483f80e5b7d1f45cf

}