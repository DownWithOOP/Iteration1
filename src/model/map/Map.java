package model.map;

import model.common.Location;
import model.map.tile.*;
import model.map.tile.areaeffect.AreaEffect;
import model.map.tile.areaeffect.AreaEffectFactory;
import utilities.XMLParser;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cduica on 2/1/17.
 */
public class Map {

    private final int GRID_HEIGHT = 3;
    private final int GRID_WIDTH = 3;
    private final String MAP_XML_PATH = "../res/map/Map.xml";

    private Tile[][] tileArray;

    public Map(){
        tileArray = new Tile[GRID_HEIGHT][GRID_WIDTH];
        ArrayList<Tile> tiles = retrieveTileList();
        createTileGrid(tiles);
    }

    public Tile getTile(int row, int col){
        return tileArray[row][col];
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
     * Obtains a list of tiles from an XML file.
     */
    private ArrayList<Tile> retrieveTileList(){

        XMLParser xmlParser = new XMLParser();
        try {
            xmlParser.loadDocument(MAP_XML_PATH);
        } catch (Exception e){
            e.printStackTrace();
        }
        ArrayList<HashMap<String, String>> tileList = xmlParser.parseDocument();

        ArrayList<Tile> tiles = new ArrayList<>();

        for(int i = 0; i < tileList.size(); i++){
            ResourceType resourceType = ResourceType.valueOf(tileList.get(i).get("Resource"));
            TerrainType terrainType = TerrainType.valueOf(tileList.get(i).get("Terrain"));
            DecalType decalType = DecalType.valueOf(tileList.get(i).get("Decal"));

            AreaEffectFactory areaEffectFactory = new AreaEffectFactory();
            AreaEffect areaEffect = areaEffectFactory.createAreaEffect(tileList.get(i).get("AreaEffect"));

            Tile tile = new Tile(
                    new Terrain(terrainType, decalType),
                    areaEffect,
                    new Resource(resourceType),
                    null
            );

            tiles.add(tile);
        }
        return tiles;
    }

    /**
     * Creates a 2d array from the list of tiles.
     * @param tiles
     */
    private void createTileGrid(ArrayList<Tile> tiles){
        int k = 0;
        for(int i = 0; i < GRID_HEIGHT; i++){
            for(int j = 0; j < GRID_WIDTH; j++){
                tileArray[i][j] = tiles.get(k);
                k++;
            }
        }
    }

}
