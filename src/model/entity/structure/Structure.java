package model.entity.structure;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.entity.Entity;
import model.entity.stats.StructureStats;
import model.common.Location;

import java.util.HashMap;

/**
 * Created by jordi on 2/2/2017.
 */
public abstract class Structure extends Entity{

    protected HashMap<TypeOfActions, Action> structureActions= new HashMap<>();


    private final Location fixedLocation;
    private StructureStats structureStats;

    public Structure(StructureStats structureStats, int xPosition, int yPosition) {
        super();
        this.initialize();
        this.structureStats = structureStats;
        fixedLocation = new Location(xPosition, yPosition);
    }

    @Override
    protected void initialize() {
        setActions();
        addAllActions(structureActions);
    }

    @Override
    protected  void setActions(){
        /**
         *         structureActions.put(TypeOfActions.powerUp,PowerUpAction(this));
         * */
    }


    public Location getFixedLocation() {
        return fixedLocation;
    }

    public void setFixedLocation(int xPosition, int yPosition) {
        this.fixedLocation.setxCoord(xPosition);
        this.fixedLocation.setyCoord(yPosition);
    }
}
