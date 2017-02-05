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

    public FighterUnit(EntityType fighterUnitType, UnitStats fighterStats, Player player, Location location) {
        super(fighterUnitType,fighterStats, player, location);
        initializeFighterUnit();
    }

    protected void initializeFighterUnit() {
        setFighterUnitActions();
        addAllActions(fighterActions);
    }

    public void abandonArmy() {
        army.removeFighter(this);
        //TODO: SET UNIT TO STANDBY
    }

    public void joinArmy(Army army) {
        if(this.army!=null){
            abandonArmy();
        }
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

    //TODO: call this function when arrived to a rally point
    private void arrivedToRallyPoint(){
        army.arrivedRallyPoint(this);
    }

    public void changeTargetLocation(){
        //TODO: run search algorithm there
    }


    //TODO: apply the same function of decommission here
    @Override
    public boolean decommission(){
        abandonArmy();
        return super.decommission();
    }

}