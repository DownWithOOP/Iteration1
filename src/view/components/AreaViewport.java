package view.components;

import model.common.Location;
import model.map.Map;
import model.map.tile.Tile;

import javax.swing.JPanel;
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


    public AreaViewport(GridBagLayout layout, Map initialMap, Location initialLocation){
        super(layout);

        setOpaque(false);
        setPreferredSize(new Dimension(500,500));

        constraints = new GridBagConstraints();

        //TODO find way to either get bounds properly or work around the fact that we don't know bounds
        numTileRows = 3; //(int) bounds.getHeight() / get;
        numTileCols = 3; //(int) bounds.getWidth();

        tiles = new TilePanel[numTileRows][numTileCols];

        mapCenter = initialLocation;

        updateTiles(initialMap);
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
                int actualYCoord = mapCenter.getyCoord() - ( numTileRows/2 - row);
                int actualXCoord = mapCenter.getxCoord() - ( numTileCols/2 - col);
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
                constraints.gridx = row;
                constraints.gridy = col;
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
