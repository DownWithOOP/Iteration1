package utilities;

import model.common.Location;
import model.map.tile.Tile;
import model.player.Player;
import model.map.Map;

import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * This is all you Konrad
 */
public class PathFinder {

    private boolean[][] obstacleGrid;

    public PathFinder(boolean[][] obstacleGrid){
        this.obstacleGrid = obstacleGrid;
    }

    public ArrayList<Location> findPath(int startX, int startY, int endX, int endY){

        return null;
    }
}