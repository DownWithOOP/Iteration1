package model.map;

import model.common.Location;
import model.map.tile.*;
import model.map.tile.areaeffect.AreaEffect;
import model.map.tile.areaeffect.AreaEffectFactory;
import model.map.tile.item.ObstacleItem;
import utilities.PathFinder;
import utilities.XMLParser;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cduica on 2/1/17.
 */
public class Map {

    private final int gridHeight;
    private final int gridWidth;

    private final String MAP_XML_PATH = "res/map/Map.xml";

    private Tile[][] tileArray;
    private boolean[][] obstacleGrid;

    public Map(){
        gridHeight = Integer.parseInt(getMapProperties("height"));
        gridWidth = Integer.parseInt(getMapProperties("width"));
        tileArray = new Tile[gridHeight][gridWidth];
        obstacleGrid = new boolean[gridHeight][gridWidth];
        ArrayList<Tile> tiles = retrieveTileList();
        createTileGrid(tiles);
    }

    /**
     * gets the tile of the map
     * @param row
     * @param col
     * @return
     */
    public Tile getTile(int row, int col){
       return tileArray[row][col];
    }

    /**
     * TODO
     * @return
     */
    public int getWidth(){ return gridWidth; }

    /**
     * TODO
     * @return
     */
    public int getHeight(){ return gridHeight; }

    /**
     * Utilizes path finding algorithm to tell a unit how to get to a particular area.
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @return List of movements.
     */
    public ArrayList<Location> findPath(int startX, int startY, int endX, int endY){
        PathFinder pathFinder = new PathFinder(obstacleGrid);
        return pathFinder.findPath(startX, startY, endX, endY);
    }

    private String getMapProperties(String propertyName){
        XMLParser xmlParser = new XMLParser();
        try {
            xmlParser.loadDocument(MAP_XML_PATH);
        } catch (Exception e){
            e.printStackTrace();
        }
        return xmlParser.getMapAttribute(propertyName);
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
            HashMap<String , String > map= tileList.get(i);
            ResourceType resourceType= ResourceType.EMPTY;
            DecalType decalType= DecalType.EMPTY;
            TerrainType terrainType= TerrainType.EMPTY;

            if (!map.get("Resource").equals("")) {
                resourceType = ResourceType.valueOf(map.get("Resource"));
            }
            if (!map.get("Terrain").equals("")) {
                terrainType = TerrainType.valueOf(map.get("Terrain"));
            }
            if (!map.get("Decal").equals("")) {
                decalType = DecalType.valueOf(map.get("Decal"));
            }

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
     * Creates an obstacle grid for path finding purposes where 'true' represents an obstacle.
     * @param tiles
     */
    private void createTileGrid(ArrayList<Tile> tiles){
        int k = 0;
        for(int i = 0; i < gridHeight; i++){
            for(int j = 0; j < gridWidth; j++){
                Tile tile = tiles.get(k);
                tileArray[i][j] = tile;
                if(tile.getItem() instanceof ObstacleItem || tile.getTerrain().getTerrainType() == TerrainType.WATER){
                    obstacleGrid[i][j] = true;
                }
                k++;
            }
        }
    }

}
