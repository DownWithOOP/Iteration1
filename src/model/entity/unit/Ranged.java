package model.entity.unit;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.common.Location;
import model.entity.stats.UnitStats;
import model.player.Player;

import java.util.HashMap;

public class Ranged extends FighterUnit {

    protected HashMap<TypeOfActions, Action> rangedActions = new HashMap<>();


    public Ranged(Player player, Location location) {

        super("Ranged", new UnitStats(10, 3, 3, 3, 100, 3, 3, 2), player, location);
        this.initializeRanged();
    }


    protected void initializeRanged() {
        setRangedActions();
        addAllActions(rangedActions);
    }

    private void setRangedActions() {
        /**
         *         rangedActions.put(TypeOfActions.powerUp,PowerUpAction(this));
         * */
    }


}