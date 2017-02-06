package model.map.tile.item;

import model.common.Location;
import model.entity.Entity;
import model.entity.unit.Unit;
import model.map.tile.Tile;

/**
 * Created by cduica on 2/4/17.
 */
public class OneShotItem extends Item {
	public OneShotItem(Location location, ItemType itemType) {
		super(location, itemType);
		/*
		if(Tile.hasEntity()){			//if Tile has entity 
			affectUnit(Tile.getEntity());	//activate OneShot
		} */
	}
	
  	public void affectUnit(Entity entity){
		Tile.removeItem();			//remove item when used
	}
}
