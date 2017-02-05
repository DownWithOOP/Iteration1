package model.map.tile;

import model.entity.unit.EntityType;
import model.entity.unit.Explorer;
import model.map.tile.areaeffect.AreaEffect;
import model.map.tile.item.Item;
import model.entity.Entity;

/**
 * Created by cduica on 2/1/17.
 */
public class Tile {

    private boolean hasEntity;
    private boolean isPassable;
    private boolean isVisible;

    private Terrain terrain;
    private AreaEffect areaEffect;
    private Resource resource;
    private Item item;
    private Entity entity;

    public Tile(Terrain terrain, AreaEffect areaEffect, Resource resource, Item item){
        this.terrain = terrain;
        this.areaEffect = areaEffect;
        this.resource = resource;
        this.item = item;
        this.isPassable = terrain.isPassable();
        this.isVisible = false;
    }

    /**
     * Assign or remove an entity from a Tile
     * @param entity
     */
    public void setEntity(Entity entity){
        this.entity = entity;
        this.hasEntity = true;
        if (entity.getEntityID().getEntityType().equals(EntityType.EXPLORER.toString())) {
            Explorer explorer = (Explorer) entity;
            explorer.findResource();
        }
    }

    public void removeEntity(){
        this.entity = null;
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

    public boolean isVisible(){
        return isVisible;
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

    public Entity getEntity() {
        return entity;
    }

    /**
     * Setters
     */

    public void setVisible(boolean isVisible){
        this.isVisible = isVisible;
    }
}
