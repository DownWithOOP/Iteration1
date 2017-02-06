package model.entity.unit;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.common.Location;
import model.entity.stats.UnitStats;
import model.player.Player;

import java.util.HashMap;

public class Melee extends FighterUnit {

    protected HashMap<TypeOfActions, Action> meleeActions = new HashMap<>();

    public Melee(Player player, Location location) {
        super(EntityType.MELEE, new UnitStats(20, 3, 5, 2, 100, 3, 1, 1), player, location);
        initializeMelee();
    }

    protected void initializeMelee() {
        setMeleeActions();
        addAllActions(meleeActions);
    }

    protected void setMeleeActions() {
        /**
         *         meleeActions.put(TypeOfActions.powerUp,PowerUpAction(this));
         * */
    }
}