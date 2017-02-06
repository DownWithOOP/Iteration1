package model.map.tile.item;

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
