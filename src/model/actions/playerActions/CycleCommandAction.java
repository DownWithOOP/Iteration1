package model.actions.playerActions;

import model.actions.ActionModifiers;
import model.actions.PlayerAction;
import model.player.Player;

public class CycleCommandAction extends PlayerAction {

    CycleCommandAction(Player player) {
        super(player);
    }

    @Override
    public void execute() {
    }

    @Override
    public void addToQueue(ActionModifiers actionModifier) {

    }
}