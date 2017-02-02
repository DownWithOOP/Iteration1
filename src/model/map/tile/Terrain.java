package model.map.tile;

/**
 * Created by cduica on 2/1/17.
 */
public class Terrain {

    private boolean isPassable;
    private boolean decalPresent;
    private TerrainType terrainType;
    private DecalType decalType;

    public Terrain(TerrainType terrainType, DecalType decalType){
        this.terrainType = terrainType;
        this.decalType = decalType;
        if(terrainType.equals(TerrainType.WATER)){
            isPassable = false;
        } else {
            isPassable = true;
        }
    }

    /**
     * Getters
     */
    public boolean isPassable(){
        return isPassable;
    }

    public boolean isDecalPresent(){
        return decalPresent;
    }

    public TerrainType getTerrainType() {
        return terrainType;
    }

    public DecalType getDecalType() {
        return decalType;
    }
}
