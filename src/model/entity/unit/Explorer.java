package model.entity.unit;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.entity.stats.UnitStats;

import java.util.HashMap;

public class Explorer extends FighterUnit {

    protected HashMap<TypeOfActions, Action> explorerActions = new HashMap<>();


    public Explorer() {

        super("Explorer",new UnitStats(2, 1, 0, 5, 50, 1, 5));
        this.initialize();
    }


    @Override
    protected void initialize() {
        setActions();
        addAllActions(explorerActions);
    }


    public void findResource() {

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
         *         explorerActions.put(TypeOfActions.powerUp,PowerUpAction(this));
         * */
    }

}