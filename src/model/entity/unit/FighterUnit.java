package model.entity.unit;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.entity.stats.UnitStats;
import model.common.Location;
import model.entity.army.Army;

import java.util.HashMap;

public abstract class FighterUnit extends Unit {
    private Army army;
    protected final HashMap<TypeOfActions,Action> fighterActions= new HashMap<>();

    public FighterUnit(UnitStats fighterStats) {
        super(fighterStats);
        this.initialize();
    }

    @Override
    protected void initialize() {
        setActions();
        addAllActions(fighterActions);
    }

    public abstract void abandonArmy() ;

    public abstract void joinArmy() ;

    @Override
    protected void setActions(){
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



}