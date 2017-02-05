package model.entity.unit;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.entity.Fighter;
import model.entity.stats.UnitStats;
import model.common.Location;
import model.entity.army.Army;
import model.player.Player;

import java.util.HashMap;

public abstract class FighterUnit extends Unit implements Fighter{
    private Army army= null;
    protected final HashMap<TypeOfActions,Action> fighterActions= new HashMap<>();

    public FighterUnit(EntityType fighterUnitType, UnitStats fighterStats, Player player, int xPos, int yPos) {
        super(fighterUnitType,fighterStats, player, xPos, yPos);
    }

    protected void initializeFighterUnit() {
        setFighterUnitActions();
        addAllActions(fighterActions);
    }

    public void abandonArmy() {
        army.removeFighter(this);
    }

    public void joinArmy(Army army) {
        if (playerId==army.getPlayerId()){
            this.army=army;
            army.registerFighter(this);
        }
    }

    private void setFighterUnitActions(){
        /**
         *         entityAction.put(TypeOfActions.powerUp,PowerUpAction(this));
         * */
    }

    @Override
    public boolean moveUnit(int x, int y) {
        this.setCurrentLocation(x,y);
        return true;
    }

    @Override
    public Location getLocation() {
        return getCurrentLocation();
    }


    @Override
    public void attack(){

    }
    @Override
    public void defend(){

    }

}