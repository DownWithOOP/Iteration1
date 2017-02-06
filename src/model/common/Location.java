package model.common;

/**
 * Created by cduica on 2/1/17.
 */
public class Location {

    private int xCoord;
    private int yCoord;

    public Location(int xCoord, int yCoord){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public boolean equals(Location location){
        int xCoord=location.getxCoord();
        int yCoord=location.getyCoord();

        if (this.xCoord==xCoord && this.yCoord==yCoord){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "(" + xCoord + "," + yCoord + ")";
    }

}
