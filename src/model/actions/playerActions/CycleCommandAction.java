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
        if (player.getSelectedRallyPoint()!=null && player.getSelectedEntity()!= null) {
            player.setSelectedAction( player.getSelectedEntity().cycleThroughActions(actionModifier));
        }else{
            if (player.getSelectedRallyPoint()!=  null) {
                player.setSelectedAction(player.getSelectedRallyPoint().cycleThroughActions(actionModifier));
            }
        }
    }

    @Override
    public String toString() {
        return "Cycle Command";
    }
}