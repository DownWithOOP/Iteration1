package model.actions.playerActions;

import model.actions.PlayerAction;
import model.player.Player;

public class CycleModeAction extends PlayerAction {

    CycleModeAction(Player player) {
        super(player);
    }

    public boolean execute() { return false; }
}