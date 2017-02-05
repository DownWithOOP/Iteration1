package model.map.tile.item;


import model.common.Location;

/**
 * Created by cduica on 2/1/17.
 */
public abstract class Item {
	public Location location;
	
	public Item(Location location){
			this.location = location;
	}
	
	public Location getLocation(){
		return location;
	}
	
	public void setLocation(int xPosition, int yPosition){
		this.location.setxCoord(xPosition);
        this.location.setyCoord(yPosition);
	}
}
