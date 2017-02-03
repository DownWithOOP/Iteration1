package model.entity.structure;

import model.entity.Entity;
import model.entity.stats.StructureStats;
import model.common.Location;

/**
 * Created by jordi on 2/2/2017.
 */
public abstract class Structure extends Entity{
    private final Location fixedLocation;
    private StructureStats structureStats;

    public Structure(StructureStats structureStats, int xPosition, int yPosition) {
        super();
        this.structureStats = structureStats;
        fixedLocation = new Location(xPosition, yPosition);
    }

    public Location getFixedLocation() {
        return fixedLocation;
    }

    public void setFixedLocation(int xPosition, int yPosition) {
        this.fixedLocation.setxCoord(xPosition);
        this.fixedLocation.setyCoord(yPosition);
    }
}
