package model.map.tile.item;


import model.common.Location;

/**
 * Created by cduica on 2/1/17.
 */
public abstract class Item {
	public Location location;
	public ItemType itemType; //enums!
	
	public Item(Location location, ItemType itemType){
		this.location = location;
		this.itemType = itemType;
	}
	
	public Location getLocation(){
		return location;
	}
	
	public void setLocation(int xPosition, int yPosition){
		this.location.setxCoord(xPosition);
        	this.location.setyCoord(yPosition);
	}
	
	public ItemType getItemType(){
		return itemType;
	}
	
	public void setItemType(ItemType itemType){
		this.itemType = itemType;
	}
}
