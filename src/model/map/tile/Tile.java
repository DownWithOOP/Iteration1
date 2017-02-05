package model.map.tile;


import model.map.tile.areaEffect.AreaEffect;
import model.map.tile.item.Item;

/**
 * Created by cduica on 2/1/17.
 */
public class Tile {

    private boolean hasEntity;
    private boolean isPassable;

    private Terrain terrain;
    private AreaEffect areaEffect;
    private Resource resource;
    private Item item;
    private String entityId;

    public Tile(Terrain terrain, AreaEffect areaEffect, Resource resource, Item item){
        this.terrain = terrain;
        this.areaEffect = areaEffect;
        this.resource = resource;
        this.item = item;
        this.isPassable = terrain.isPassable();
    }

    /**
     * Assign or remove an entity from a Tile
     * @param entityId
     */
    public void setEntity(String entityId){
        this.entityId = entityId;
        this.hasEntity = true;
    }

    public void removeEntity(){
        this.entityId = null;
        this.hasEntity = false;
    }

    /**
     * Getters
     */
    public boolean hasEntity() {
        return hasEntity;
    }

    public boolean isPassable() {
        return isPassable;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public AreaEffect getAreaEffect() {
        return areaEffect;
    }

    public Resource getResource() {
        return resource;
    }

    public Item getItem() {
        return item;
    }

    public String getEntityId() {
        return entityId;
    }

}
