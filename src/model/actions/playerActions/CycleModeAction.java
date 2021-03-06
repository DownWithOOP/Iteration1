package model.actions.playerActions;

import model.actions.ActionModifiers;
import model.actions.PlayerAction;
import model.player.Player;

public class CycleModeAction extends PlayerAction {

    public CycleModeAction(Player player) {
        super(player);
    }

    public void execute() {
        player.cycleMode(actionModifier);
    }

    @Override
    public String toString() {
        return "Cycle Mode";
    }
}