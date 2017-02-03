package model.actions.playerActions;

import model.actions.ActionModifiers;
import model.actions.PlayerAction;
import model.player.Player;

public class CycleTypeAction extends PlayerAction {

    CycleTypeAction(Player player) {
        super(player);
    }

    public void execute() {  }

    @Override
    public void addToQueue(ActionModifiers actionModifier) {

    }
}