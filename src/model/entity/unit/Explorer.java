package model.entity.unit;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.entity.stats.UnitStats;

import java.util.HashMap;

public class Explorer extends FighterUnit {

    protected HashMap<TypeOfActions, Action> explorerActions = new HashMap<>();


    public Explorer() {

        super("Explorer",new UnitStats(2, 1, 0, 5, 50, 1, 5));
        this.initializeExplorer();
    }



    protected void initializeExplorer() {
        setExplorerActions();
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

    private void setExplorerActions(){
        /**
         *         explorerActions.put(TypeOfActions.powerUp,PowerUpAction(this));
         * */
    }

}