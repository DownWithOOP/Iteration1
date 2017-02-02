package model.actions.playerActions;

import model.actions.PlayerAction;
import model.player.Player;

public class CycleInstanceAction extends PlayerAction {

    CycleInstanceAction(Player player) {
            super(player);
    }

    public boolean execute() { return false; }
}