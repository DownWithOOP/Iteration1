package model.actions;

import model.player.Player;

public abstract class PlayerAction implements Action {
    protected ActionModifiers actionModifier=ActionModifiers.none;
    protected Player player;

    public PlayerAction(Player player) {
        this.player = player;
    }
    @Override
    public void applyModifier(ActionModifiers actionModifier) {
        this.actionModifier=actionModifier;
        execute();
    }

}