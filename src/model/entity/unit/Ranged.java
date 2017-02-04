package model.entity.unit;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.entity.stats.UnitStats;

import java.util.HashMap;

public class Ranged extends FighterUnit {

    protected HashMap<TypeOfActions, Action> rangedActions = new HashMap<>();


    public Ranged() {

        super ("Ranged",new UnitStats(10, 3, 3, 3, 100, 3, 3));
        this.initializeRanged();
    }


    protected void initializeRanged() {
        setRangedActions();
        addAllActions(rangedActions);
    }

    @Override
    public void abandonArmy() {

    }

    @Override
    public void joinArmy() {

    }

    private void setRangedActions(){
        /**
         *         rangedActions.put(TypeOfActions.powerUp,PowerUpAction(this));
         * */
    }


}