package model.actions.playerActions;

import model.actions.PlayerAction;
import model.player.Player;

/**
 * Created by jordi on 2/6/2017.
 */
public class ActivateCommandAction extends PlayerAction {

    public ActivateCommandAction(Player player) {
        super(player);
    }

    @Override
    public void execute() {
        if (player.getSelectedAction()!=null){
            player.getSelectedAction().execute();
            player.setSelectedAction(null);
        }
    }

    @Override
    public String toString() {
        return "Activate Command";
    }
}
