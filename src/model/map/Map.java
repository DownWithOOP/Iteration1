package model.map;

import model.common.Location;
import model.map.tile.Tile;

import java.util.ArrayList;

/**
 * Created by cduica on 2/1/17.
 */
public class Map {

    private final int GRID_HEIGHT = 10;
    private final int GRID_WIDTH = 10;

    private Tile[][] tileArray;

    Map(){
        tileArray = new Tile[GRID_HEIGHT][GRID_WIDTH];
    }

    public Tile getTile(Location location){

        return new Tile();
    }

    public ArrayList<Location> findPath(){

        return new ArrayList<>();
    }

    private void createTileGrid(){

    }



}
