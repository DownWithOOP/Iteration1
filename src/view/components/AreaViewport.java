package view.components;

import model.common.Location;
import model.common.RenderObject;
import model.map.Map;
import model.map.tile.Tile;
import org.w3c.dom.css.Rect;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AreaViewport extends JPanel {

    private Image[][] tiles;
    private Rectangle bounds;

    private Location mapCenter;

    private int tileHieght;
    private int tileWidth;
    private int numTileRows;
    private int numTileCols;


    private Image waterImage;
    private Image craterImage;
    private Image grassImage;
    private Image dirtImage;


    public AreaViewport(Map initalMap, Location initialLocation){
        //Get images
        Toolkit tool = Toolkit.getDefaultToolkit();
        waterImage = tool.getImage("res/images/water.png");
        craterImage = tool.getImage("res/images/crater.png");
        grassImage = tool.getImage("res/images/grass.png");
        dirtImage = tool.getImage("res/images/dirt.png");



        setBackground(Color.black);
        setVisible(true);

        System.out.println("SIZE IS HUUUUUUUUUUUUUUUGE" + getSize());

        bounds = new Rectangle(getSize());

        //TODO determine num tiles from ht/wid from images.
        numTileRows = 3; //(int) bounds.getHeight() / get;
        numTileCols = 3; //(int) bounds.getWidth();

        tileHieght = (int) bounds.getHeight()/numTileRows;
        tileWidth = (int) bounds.getWidth()/numTileCols;

        tiles = new Image[initalMap.getHeight()][initalMap.getWidth()];

        mapCenter = initialLocation;

        updateTiles(initalMap);
    }

    private void updateTiles(Map map) {
        System.out.println("SIZE IS HUUUUUUUUUUUUUUUGE" + getSize());
        for (int row = 0; row < numTileRows; ++row){
            for (int col = 0; col < numTileCols; ++col){
                //TODO handle when actualYCoord and actualXCoord go off of the map
                int actualYCoord = mapCenter.getyCoord() - ( numTileRows/2 - row);
                int actualXCoord = mapCenter.getxCoord() - ( numTileCols/2 - col);
                Tile currentTile = map.getTile(actualYCoord, actualXCoord);
                switch (currentTile.getTerrain().getTerrainType()) {
                    case DIRT:
                        tiles[row][col] = dirtImage;
                        System.out.println("dirt");
                        break;
                    case CRATER:
                        tiles[row][col] = craterImage;
                        System.out.println("crater");
                        break;
                    case GRASS:
                        tiles[row][col] = grassImage;
                        System.out.println("grass");
                        break;
                    case WATER:
                        tiles[row][col] = waterImage;
                        System.out.println("water");
                        break;
                    default:
                        tiles[row][col] = dirtImage;
                        System.out.println("nada");
                        break;
                }
                //TODO look up image based on tile type
                //TODO get entityID from tile and parse
            }
        }
    }

    public void update(Map updatedMap, Location updatedMapCenter){
        System.out.println("SIZE IS HUUUUUUUUUUUUUUUGE" + getSize());
        System.out.println("AREAVIEWPORT X LOCATION IS HUUUUUUUUUUUUUUUGE " + getX());
        System.out.println("AREAVIEWPORT Y LOCATION IS HUUUUUUUUUUUUUUUGE " + getY());
        tileHieght = (int) bounds.getHeight()/numTileRows;
        tileWidth = (int) bounds.getWidth()/numTileCols;
        mapCenter = updatedMapCenter;
        updateTiles(updatedMap);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);//do I need this??? IDK
        Graphics2D g2 = (Graphics2D) g;
        for (int row = 0; row < numTileRows; ++row){
            for (int col = 0; col < numTileCols; ++col){
                //TODO look up image based on tile type
                //TODO get entityID from tile and parse
                g.drawImage(tiles[row][col], (col+1)*getX(), (row+1)*getY(), getWidth(), getHeight(), this);
            }
        }
        System.out.println("PAINTING AREA VIEWPORT");
    }
}
