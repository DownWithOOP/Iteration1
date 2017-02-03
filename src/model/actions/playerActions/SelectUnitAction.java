package model.actions.playerActions;

import com.sun.media.jfxmedia.events.PlayerEvent;
import model.actions.Action;
import model.actions.PlayerAction;
import model.player.Player;

/**
 * Created by jordi on 2/2/2017.
 */
public class SelectUnitAction extends PlayerAction {
    public SelectUnitAction(Player player) {
        super(player);
    }

    @Override
    public boolean execute() {

        return false;
    }
}
