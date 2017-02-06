package model.map.tile.item;


import model.common.Location;
import model.map.tile.Tile;

/**
 * Created by cduica on 2/4/17.
 */
public class ObstacleItem extends Item {
    public ObstacleItem(Location location, ItemType itemType) {
        super(location, itemType);
        ObstacleItemEffect();
    }
    public void ObstacleItemEffect(){
        Tile.setIsPassable(false);
    }
}
