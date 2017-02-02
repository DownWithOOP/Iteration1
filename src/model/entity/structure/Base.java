package model.entity.structure;

import model.common.Location;

/**
 * Created by jordi on 2/2/2017.
 */
public class Base extends Structure {
    public Base(int rowPosition, int columnPosition, int visionRadius) {
        super(visionRadius);
    }

    @Override
    public Location getLocation() {
        return null;
    }


}
