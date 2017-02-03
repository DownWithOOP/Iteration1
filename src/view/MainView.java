package view;

import model.map.Map;
import model.map.tile.Terrain;
import model.map.tile.DecalType;

public class MainView extends View {

    //Need to find out about Image type; just put int in for now
    java.util.Map<Terrain, Integer> terrainBuffer;
    java.util.Map<DecalType, Integer> decalBuffer;
    java.util.Map<Integer, Integer> entityBuffer;

    View areaViewport;
    View statusViewport;

    MainView(){

    }

    public boolean start(){ return false; }

    public boolean update() { return false; }

    public boolean close() { return false; }

    protected boolean render() { return false; }
}