package utilities;

import model.common.Location;
import java.util.*;

/**
 * This is all you Konrad
 */
public class PathFinder {

    private boolean[][] obstacleGrid;

    public PathFinder(boolean[][] obstacleGrid){
        this.obstacleGrid = obstacleGrid;
    }

    // TODO NOTE: BFS tested and works correctly-Konrad, might be some issues with obsactles though
    public ArrayList<Location> findPath(int startX, int startY, int endX, int endY){

        Queue<LocationInfo> queue = new LinkedList<LocationInfo>();



        LocationInfo start = new LocationInfo();
        Location start1 = new Location(startX, startY);
        start.fromInformation= start1;
        start.meInformation = start1;
        queue.add(start);

        LocationInfo[][] visited = new LocationInfo[this.obstacleGrid[0].length][this.obstacleGrid.length];
        boolean[][] visited2 = new boolean[this.obstacleGrid[0].length][this.obstacleGrid.length]; // everything is false by default
        visited[startX][startY] = start; // set the starting locationInfo object

        // up, down, right, left
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        boolean found = false;
        LocationInfo endLocation = null;
        ArrayList<Location> answer = new ArrayList<Location>();

        while(!found || !queue.isEmpty()){

            LocationInfo current = queue.poll(); // get the current location in the queue

            // check if it is the actual point
            // we check if it is
            if(visited2[current.meInformation.getxCoord()][current.meInformation.getyCoord()] == false){

                // we mark it is visited
                visited2[current.meInformation.getxCoord()][current.meInformation.getyCoord()] = true;
                // not visited perform BFS
                for(int i=0; i<4; i++){
                    int checkx =current.meInformation.getxCoord() + dx[i];
                    int checky = current.meInformation.getyCoord() + dy[i];


                    if((checkx >=0) && (checkx < obstacleGrid[0].length) && (checky >= 0) && (checky < obstacleGrid.length)  ){
                        // it is within bounds, we need to test it

                        if(visited2[checkx][checky] == false && obstacleGrid[checkx][checky] == false){
                            // not visited object yet
                            LocationInfo addMe = new LocationInfo();
                            Location temp1 = new Location(current.meInformation.getxCoord(), current.meInformation.getyCoord());
                            Location temp2 = new Location(checkx, checky);
                            addMe.fromInformation= temp1;
                            addMe.meInformation = temp2;
                            visited[checkx][checky] = addMe;
                            queue.add(addMe);
                        } else{
                            // already visited
                        }
                    }
                }
            } else {
                // visited, do nothing
            }

            if(current.meInformation.getxCoord() == endX && current.meInformation.getyCoord() == endY){
                // answer found
                found = true;
                endLocation = current;
                break;
            }
        }

        if(!found){
            return null;
        } else{
            // now we backtrack until we have all the points
            LocationInfo current = endLocation;

            while(current.meInformation != start1 && current.fromInformation != start1){
                // we keep on going until we get back to the origin
                System.out.println(current.meInformation.toString());
                answer.add(current.meInformation);
                current = visited[current.fromInformation.getxCoord()][current.fromInformation.getyCoord()];
            }
            Collections.reverse(answer);
            return answer;
        }
    }
}

class LocationInfo{ // like a struct to keep track of BFS

    Location meInformation;
    Location fromInformation;

}
