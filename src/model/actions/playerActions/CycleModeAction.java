package model.actions.playerActions;

import model.actions.ActionModifiers;
import model.actions.PlayerAction;
import model.player.Player;

public class CycleModeAction extends PlayerAction {

    CycleModeAction(Player player) {
        super(player);
    }

    public void execute() { }

    @Override
    public void addToQueue(ActionModifiers actionModifier) {

    }
}