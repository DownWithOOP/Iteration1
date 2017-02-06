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

    private static final int NUM_TILE_ROWS = 5;
    private static final int NUM_TILE_COLS = 5;
    private final int TILE_HEIGHT;
    private final int TILE_WIDTH;

    private static final String armyImagePath = "res/images/army.png";
    private static final String baseImagePath = "res/images/base.png";
    private static final String colonistImagePath = "res/images/colonist.png";
    private static final String explorerImagePath = "res/images/explorer.png";
    private static final String meleeImagePath = "res/images/melee.png";
    private static final String rangedImagePath = "res/images/ranged.png";

    private static final String waterImagePath = "res/images/water.png";
    private static final String craterImagePath = "res/images/crater.png";
    private static final String grassImagePath = "res/images/grass.png";
    private static final String dirtImagePath = "res/images/dirt.png";

    private GridBagConstraints constraints;


    public AreaViewport(GridBagLayout layout, Rectangle mainViewBounds, Map initialMap, Location initialLocation){
        super(layout);

        setOpaque(false);

        this.bounds = mainViewBounds;
        setPreferredSize(new Dimension((int)bounds.getWidth(),(int)bounds.getHeight()));

        constraints = new GridBagConstraints();

        //TODO find way to either get bounds properly or work around the fact that we don't know bounds
        System.out.println(initialMap.getWidth() + "," + initialMap.getHeight());
        TILE_WIDTH = (int) bounds.getWidth()/NUM_TILE_COLS;
        TILE_HEIGHT = (int) bounds.getHeight()/NUM_TILE_ROWS;

        tiles = new TilePanel[NUM_TILE_ROWS][NUM_TILE_COLS];

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
        for (int row = 0; row < NUM_TILE_ROWS; ++row){
            for (int col = 0; col < NUM_TILE_COLS; ++col){
                if(tiles[row][col] != null) {
                    remove(tiles[row][col]);
                }
                //TODO handle when actualYCoord and actualXCoord go off of the map
                System.out.println(mapCenter);
                System.out.println("row: " + row + "col: " + col);
                int actualXCoord = mapCenter.getxCoord() - ( NUM_TILE_COLS /2 - col);
                int actualYCoord = mapCenter.getyCoord() - ( NUM_TILE_ROWS /2 - row);
                if (actualXCoord < 0 || actualYCoord < 0){
                    actualXCoord = NUM_TILE_COLS /2;
                    actualYCoord = NUM_TILE_ROWS /2;
                }
                System.out.println("x: " + actualXCoord + "y: " + actualYCoord);
                Tile currentTile = map.getTile(actualYCoord, actualXCoord);
                switch (currentTile.getTerrain().getTerrainType()){
                    case DIRT:
                        tiles[row][col] = new TilePanel(dirtImagePath, TILE_WIDTH, TILE_HEIGHT);
                        break;
                    case CRATER:
                        tiles[row][col] = new TilePanel(craterImagePath, TILE_WIDTH, TILE_HEIGHT);
                        break;
                    case GRASS:
                        tiles[row][col] = new TilePanel(grassImagePath, TILE_WIDTH, TILE_HEIGHT);
                        break;
                    case WATER:
                        tiles[row][col] = new TilePanel(waterImagePath, TILE_WIDTH, TILE_HEIGHT);
                        break;
                    default:
                        tiles[row][col] = new TilePanel(dirtImagePath, TILE_WIDTH, TILE_HEIGHT);
                        break;
                }
                if (currentTile.hasEntity()){
                    switch (currentTile.getEntity().getEntityID().getEntityType(0)){
                        case ARMY:
                            tiles[row][col].addEntityImage(armyImagePath);
                            break;
                        case BASE:
                            tiles[row][col].addEntityImage(baseImagePath);
                            break;
                        case COLONIST:
                            tiles[row][col].addEntityImage(colonistImagePath);
                            break;
                        case EXPLORER:
                            tiles[row][col].addEntityImage(explorerImagePath);
                            break;
                        case MELEE:
                            tiles[row][col].addEntityImage(meleeImagePath);
                            break;
                        case RANGED:
                            tiles[row][col].addEntityImage(rangedImagePath);
                            break;
                        default:
                            tiles[row][col].addEntityImage(meleeImagePath);
                    }
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
