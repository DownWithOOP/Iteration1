package model.actions.playerActions;

import model.actions.ActionModifiers;
import model.actions.PlayerAction;
import model.player.Player;

public class CycleInstanceAction extends PlayerAction {

    public CycleInstanceAction(Player player) {
            super(player);
    }

    public void execute() {
        player.cycleInstance(actionModifier);
    }

    @Override
    public String toString() {
        return "Cycle Instance";
    }
}