package model.map;

import model.common.Location;
import model.map.tile.*;
import utilities.XMLParser;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cduica on 2/1/17.
 */
public class Map {

    private final int GRID_HEIGHT = 10;
    private final int GRID_WIDTH = 10;
    private final String MAPXML_PATH = "../res/map/Map.xml";

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

        XMLParser xmlParser = new XMLParser();
        try {
            xmlParser.loadDocument(MAPXML_PATH);
        } catch (Exception e){
            e.printStackTrace();
        }
        ArrayList<HashMap<String, String>> tileList = xmlParser.parseDocument();

        ArrayList<Tile> tiles = new ArrayList<>();

        //TODO: finish this
        for(int i = 0; i < tileList.size(); i++){
            ResourceType resourceType = ResourceType.valueOf(tileList.get(i).get("Resource").toUpperCase());
            TerrainType terrainType = TerrainType.valueOf(tileList.get(i).get("Terrain").toUpperCase());
            DecalType decalType = DecalType.valueOf(tileList.get(i).get("Decal").toUpperCase());
            Terrain terrain = new Terrain(terrainType, decalType);
        }

    }



}
