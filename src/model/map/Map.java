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

    public Map(){
        tileArray = new Tile[GRID_HEIGHT][GRID_WIDTH];
        createTileGrid();
    }

    public Tile getTile(Location location){

        return new Tile(null, null, null, null);
    }

    /**
     * Utilizes path finding algorithm to tell a unit how to get to a particular area.
     * @param startPoint
     * @param endPoint
     * @return List of movements.
     */
    public ArrayList<Location> findPath(Location startPoint, Location endPoint){

        return new ArrayList<>();
    }

    /**
     * Initializes tile array from external XML file.
     */
    private void createTileGrid(){

    }



}
