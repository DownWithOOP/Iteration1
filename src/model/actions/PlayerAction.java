package model.actions;

import model.player.Player;

public abstract class PlayerAction implements Action {

    public PlayerAction(Player player) {
        //this.player = player;
    }

    @Override
    public abstract boolean execute();

    @Override
    public boolean addToQueue(){
        //player.addToQueue()
        return false;
    }
}