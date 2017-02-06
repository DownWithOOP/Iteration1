package model.map.tile.item;

import model.common.Location;
import model.entity.unit.Unit;

/**
 * Created by cduica on 2/4/17.
 */
public class OneShotItem extends Item {
	public OneShotItem(Location location, ItemType itemType) {
		super(location, itemType);
	}
	//public ItemEffect itemEffect;
	
  	public void affectUnit(Unit unit){
		
	}
}
