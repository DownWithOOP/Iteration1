package model.map.tile;

import model.entity.unit.EntityType;
import model.entity.unit.Explorer;
import model.map.tile.areaeffect.AreaEffect;
import model.map.tile.item.Item;
import model.entity.Entity;

import java.util.ArrayList;
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
            ArrayList<Tile> adjacentTiles = getAdjacentTiles(this, explorer);
            discoverResources(adjacentTiles,explorer);
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

    public ArrayList<Tile> getAdjacentTiles(Tile currentTile, Entity entity) {
        int row = entity.getLocation().getxCoord();
        int col = entity.getLocation().getyCoord();
        ArrayList<Tile> adjacentTiles = new ArrayList<Tile>();
        adjacentTiles.add(currentTile);
        if ((row + 1) < entity.getPlayer().getPlayerMap().getWidth()) {
            Tile downTile = entity.getPlayer().getPlayerMap().getTile(row+1, col);
            adjacentTiles.add(downTile);
        }
        if ((row - 1) > 0) {
            Tile upTile = entity.getPlayer().getPlayerMap().getTile(row-1, col);
            adjacentTiles.add(upTile);
        }
        if ((col + 1) < entity.getPlayer().getPlayerMap().getHeight()) {
            Tile rightTile = entity.getPlayer().getPlayerMap().getTile(row, col+1);
            adjacentTiles.add(rightTile);
        }
        if ((col - 1) > 0) {
            Tile leftTile = entity.getPlayer().getPlayerMap().getTile(row, col-1);
            adjacentTiles.add(leftTile);
        }

        return adjacentTiles;
    }

    public void discoverResources(ArrayList<Tile> adjacentTiles, Explorer explorer) {
        for(Tile tile: adjacentTiles) {
            int minedResources = 0;
            if (tile.getResource() != null && tile.getResource().getResourceType().equals(ResourceType.CATFOOD.toString())) {
                minedResources = getResource().mine();
                explorer.getPlayer().setCatfoodResourceLevel(explorer.getPlayer().catfoodResourceLevel() + minedResources);

            }
            else if (tile.getResource() != null && tile.getResource().getResourceType().equals(ResourceType.CRYSTAL.toString())) {
                minedResources = getResource().mine();
                explorer.getPlayer().setCrystalResourceLevel(explorer.getPlayer().crystalResourceLevel() + minedResources);
            }
            else if (tile.getResource() != null && tile.getResource().getResourceType().equals(ResourceType.RESEARCH.toString())) {
                minedResources = getResource().mine();
                explorer.getPlayer().setResearchResourceLevel(explorer.getPlayer().crystalResourceLevel() + minedResources);
            }
        }
    }
}
