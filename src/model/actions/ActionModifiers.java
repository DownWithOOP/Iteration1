package model.actions;

/**
 * Created by jordi on 2/3/2017.
 */
public enum ActionModifiers {
    up(1),down(-1),left(-1),right(1),
    zero(0), one(1), two(2), three(3), four(4), five(5), six(6), seven(7), eight(8), nine(9),
    none(0);
    private int value;
    ActionModifiers(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
