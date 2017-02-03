package model.actions.playerActions;

import model.actions.PlayerAction;
import model.player.Player;

public class CycleCommandAction extends PlayerAction {

    CycleCommandAction(Player player) {
        super(player);
    }

    public boolean execute() { return false; }
}