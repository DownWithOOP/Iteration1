package model.entity.structure;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.entity.Entity;
import model.entity.stats.StructureStats;
import model.common.Location;
import model.player.Player;
import model.entity.unit.EntityType;

import java.util.HashMap;

/**
 * Created by jordi on 2/2/2017.
 */
public abstract class Structure extends Entity{

    protected HashMap<TypeOfActions, Action> structureActions= new HashMap<>();


    private final Location fixedLocation;
    private StructureStats structureStats;

    public Structure(EntityType entityType, StructureStats structureStats, int xPosition, int yPosition, Player player) {
        super(player, entityType);
        initializeStructure();
        this.structureStats = structureStats;
        fixedLocation = new Location(xPosition, yPosition);
    }

    protected void initializeStructure() {
        setStructureActions();
        addAllActions(structureActions);
    }

    protected  void setStructureActions(){
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
