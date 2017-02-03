package model.actions.playerActions;

import model.actions.PlayerAction;
import model.player.Player;

public class CycleTypeAction extends PlayerAction {

    CycleTypeAction(Player player) {
        super(player);
    }

    public boolean execute() { return false; }
}