package view.components;

import model.common.Location;
import model.map.Map;
import model.map.tile.Tile;

import javax.swing.*;
import java.awt.*;

public class AreaViewport extends JPanel {

    private TilePanel[][] tiles;
    private Rectangle bounds;

    private Location mapCenter;

    private int numTileRows;
    private int numTileCols;


    private static final String waterImagePath = "res/images/water.png";
    private static final String craterImagePath = "res/images/crater.png";
    private static final String grassImagePath = "res/images/grass.png";
    private static final String dirtImagePath = "res/images/dirt.png";

    private GridBagConstraints constraints;


    public AreaViewport(GridBagLayout layout, Rectangle bounds, Map initialMap, Location initialLocation){
        super(layout);

        setOpaque(false);
        //TODO remove hard coded dimensions
        setPreferredSize(new Dimension((int)bounds.getWidth(),(int)bounds.getHeight()));

        constraints = new GridBagConstraints();

        //TODO find way to either get bounds properly or work around the fact that we don't know bounds
        numTileRows = initialMap.getWidth(); //(int) bounds.getHeight() / get;
        numTileCols = initialMap.getHeight(); //(int) bounds.getWidth();

        tiles = new TilePanel[numTileRows][numTileCols];

        mapCenter = initialLocation;

        //Fill to left of tiles
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.weightx = 1;
        add(Box.createGlue(), constraints);

        //Set up tiles
        updateTiles(initialMap);

        //Fill to right of tiles
        constraints.gridx +=1;
        constraints.weightx =1;
        add(Box.createGlue(), constraints);
        setVisible(true);
    }

    private void updateTiles(Map map) {
        System.out.println("SIZE IS HUUUUUUUUUUUUUUUGE" + getSize());
        for (int row = 0; row < numTileRows; ++row){
            for (int col = 0; col < numTileCols; ++col){
                if(tiles[row][col] != null) {
                    remove(tiles[row][col]);
                }
                //TODO handle when actualYCoord and actualXCoord go off of the map
                System.out.println(mapCenter);
                System.out.println("row: " + row + "col: " + col);
                int actualXCoord = mapCenter.getxCoord() - ( numTileCols/2 - col);
                int actualYCoord = mapCenter.getyCoord() - ( numTileRows/2 - row);
                if (actualXCoord < 0 || actualYCoord < 0){
                    actualXCoord = numTileCols/2;
                    actualYCoord = numTileRows/2;
                }
                System.out.println("x: " + actualXCoord + "y: " + actualYCoord);
                Tile currentTile = map.getTile(actualYCoord, actualXCoord);
                switch (currentTile.getTerrain().getTerrainType()) {
                    case DIRT:
                        tiles[row][col] = new TilePanel(dirtImagePath);
                        break;
                    case CRATER:
                        tiles[row][col] = new TilePanel(craterImagePath);
                        break;
                    case GRASS:
                        tiles[row][col] = new TilePanel(grassImagePath);
                        break;
                    case WATER:
                        tiles[row][col] = new TilePanel(waterImagePath);
                        break;
                    default:
                        tiles[row][col] = new TilePanel(dirtImagePath);
                        break;
                }
                //TODO look up image based on tile type
                //TODO get entityID from tile and parse
                constraints.gridx = row+1;
                constraints.gridy = col+1;
                constraints.insets = new Insets(1,1,1,1);
                constraints.fill = GridBagConstraints.BOTH;
                constraints.weightx = 0.5;
                constraints.weighty = 0.5;
                add(tiles[row][col], constraints);
            }
        }
    }

    public void update(Map updatedMap, Location updatedMapCenter){
        System.out.println("SIZE IS HUUUUUUUUUUUUUUUGE" + getSize());
        System.out.println("AREAVIEWPORT X LOCATION IS HUUUUUUUUUUUUUUUGE " + getX());
        System.out.println("AREAVIEWPORT Y LOCATION IS HUUUUUUUUUUUUUUUGE " + getY());
        mapCenter = updatedMapCenter;
        updateTiles(updatedMap);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);//do I need this??? IDK
        System.out.println("PAINTING AREA VIEWPORT");
    }
}
