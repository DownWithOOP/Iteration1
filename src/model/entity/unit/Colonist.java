package model.entity.unit;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.entity.stats.UnitStats;
import model.entity.structure.Base;

import java.util.HashMap;

public class Colonist extends FighterUnit {

    protected HashMap<TypeOfActions, Action> colonistActions = new HashMap<>();


    public Colonist() {
        super(new UnitStats(2, 1, 0, 3, 50, 1, 5));
        this.initialize();
    }


    @Override
    protected void initialize() {
        setActions();
        addAllActions(colonistActions);
    }


    @Override
    public void abandonArmy() {

    }

    @Override
    public void joinArmy() {

    }

    @Override
    protected void setActions(){
        /**
         *         colonistActions.put(TypeOfActions.powerUp,PowerUpAction(this));
         * */
    }


//    public Base buildStructure(int rowPosition, int columnPosition) {
//        return new Base(rowPosition, columnPosition,visionRadius);
//    }

}