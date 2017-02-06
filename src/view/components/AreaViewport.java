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
        int actualYCoord = getActualStartingY(mapCenter);
        for (int row = 0; row < NUM_TILE_ROWS; ++row){
            int actualXCoord = getActualStartingX(mapCenter);
            for (int col = 0; col < NUM_TILE_COLS; ++col){
                if(tiles[row][col] != null) {
                    remove(tiles[row][col]);
                }
                Tile currentTile = new Tile();
                try {
                    currentTile = map.getTile(actualYCoord, actualXCoord);
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println(e.getMessage());
                }
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
                            tiles[row][col].addEntityImage("");
                    }
                }

                constraints.gridx = row+1;
                constraints.gridy = col+1;
                constraints.insets = new Insets(1,1,1,1);
                constraints.fill = GridBagConstraints.BOTH;
                constraints.weightx = 0.5;
                constraints.weighty = 0.5;
                add(tiles[row][col], constraints);

                ++actualXCoord;
            }
            ++actualYCoord;
        }
    }

    private int getActualStartingX(Location mapCenter) {
        if (mapCenter.getxCoord() < NUM_TILE_COLS/2){
            return getActualStartingX(new Location(mapCenter.getxCoord() + 1, mapCenter.getyCoord()));
        }
        else if (mapCenter.getxCoord() + NUM_TILE_COLS/2 > NUM_TILE_COLS){
            return getActualStartingX(new Location(mapCenter.getxCoord() - 1, mapCenter.getyCoord()));
        }
        else{
            return mapCenter.getxCoord() - NUM_TILE_COLS/2 - 1;
        }
    }

    private int getActualStartingY(Location mapCenter) {
        if (mapCenter.getyCoord() < NUM_TILE_ROWS/2){
            return getActualStartingY(new Location(mapCenter.getxCoord(), mapCenter.getyCoord() + 1));
        }
        else if (mapCenter.getyCoord() + NUM_TILE_ROWS/2 > NUM_TILE_ROWS){
            return getActualStartingX(new Location(mapCenter.getxCoord() - 1, mapCenter.getyCoord()));
        }
        else{
            return mapCenter.getyCoord() - NUM_TILE_ROWS/2;
        }
    }

    public void update(Map updatedMap, Location updatedMapCenter){
        mapCenter = updatedMapCenter;
        updateTiles(updatedMap);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);//do I need this??? IDK
    }
}
