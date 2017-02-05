package model.entity.unit;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.entity.stats.UnitStats;
import model.player.Player;

import java.util.HashMap;

public class Ranged extends FighterUnit {

    protected HashMap<TypeOfActions, Action> rangedActions = new HashMap<>();


    public Ranged(Player player, int xPos, int yPos) {

        super (EntityType.RANGED,new UnitStats(10, 3, 3, 3, 100, 3, 3),
                player, xPos, yPos);
        this.initializeRanged();
    }

    @Override
    public void update() {

    }

    protected void initializeRanged() {
        setRangedActions();
        addAllActions(rangedActions);
    }

    private void setRangedActions(){
        /**
         *         rangedActions.put(TypeOfActions.powerUp,PowerUpAction(this));
         * */
    }


}