package model.entity.unit;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.entity.stats.UnitStats;

import java.util.HashMap;

public class Ranged extends FighterUnit {

    protected HashMap<TypeOfActions, Action> rangedActions = new HashMap<>();


    public Ranged() {

        super (new UnitStats(10, 3, 3, 3, 100, 3, 3));
        this.initialize();
    }


    @Override
    protected void initialize() {
        setActions();
        addAllActions(rangedActions);
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
         *         rangedActions.put(TypeOfActions.powerUp,PowerUpAction(this));
         * */
    }


}