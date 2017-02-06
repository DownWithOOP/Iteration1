package model.actions.playerActions;

import model.actions.ActionModifiers;
import model.actions.PlayerAction;
import model.player.Player;

public class CycleTypeAction extends PlayerAction {

    public CycleTypeAction(Player player) {
        super(player);
    }

    public void execute() {
        player.cycleTypes(actionModifier);
    }


}