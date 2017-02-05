package model.map.tile.item;


import model.common.Location;

/**
 * Created by cduica on 2/4/17.
 */
public class ObstacleItem extends Item {
    public ObstacleItem(Location location) {
        super(location);
        ObstacleItemEffect();
    }
    public ObstacleItemEffect(){
        this.isPassable = false;
    }
}
