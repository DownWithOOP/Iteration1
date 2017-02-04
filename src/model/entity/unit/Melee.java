package model.entity.unit;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.entity.stats.UnitStats;

import java.util.HashMap;

public class Melee extends FighterUnit {

    protected HashMap<TypeOfActions, Action> meleeActions = new HashMap<>();


    public Melee() {

        super("Melee",new UnitStats(20, 3, 5, 2, 100, 3, 1));
        initializeMelee();
    }


    protected void initializeMelee() {
        setMeleeActions();
        addAllActions(meleeActions);
    }


    @Override
    public void abandonArmy() {

    }

    @Override
    public void joinArmy() {

    }

    protected void setMeleeActions(){
        /**
         *         meleeActions.put(TypeOfActions.powerUp,PowerUpAction(this));
         * */
    }
}