package model.entity.unit;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.common.Location;
import model.entity.stats.UnitStats;
import model.entity.structure.Base;
import model.player.Player;

import java.util.HashMap;

public class Colonist extends FighterUnit {

    protected HashMap<TypeOfActions, Action> colonistActions = new HashMap<>();


    public Colonist(Player player, Location location) {
        super("Colonist", new UnitStats(2, 1, 0, 3, 50, 1, 5,1),player, location);

        initializeColonist();
    }


    protected void initializeColonist() {
        setColonistActions();
        addAllActions(colonistActions);
    }


    private void setColonistActions(){
        /**
         *         colonistActions.put(TypeOfActions.powerUp,PowerUpAction(this));
         * */
    }


//    public Base buildStructure(int rowPosition, int columnPosition) {
//        return new Base(new structureStats(),rowPosition, columnPosition);
//    }

}