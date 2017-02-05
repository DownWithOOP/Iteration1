package model.actions.playerActions;

import model.actions.ActionModifiers;
import model.actions.PlayerAction;
import model.player.Player;

public class CycleCommandAction extends PlayerAction {

    public CycleCommandAction(Player player) {
        super(player);
    }

    @Override
    public void execute() {
    }

    @Override
    public void applyModifier(ActionModifiers actionModifier) {

    }
}