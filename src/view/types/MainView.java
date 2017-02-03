package view.types;

import javafx.scene.layout.Pane;
import model.common.GraphicsInfo;

import view.View;
import view.components.AreaViewport;
import view.components.StatusViewport;

public class MainView extends View {

    //Need to find out about Image type; just put int in for now
    java.util.Map<GraphicsInfo, Integer> graphicsBuffer;

    View areaViewport;
    View statusViewport;

    public MainView(){

    }

    @Override
    public void start() {
        Pane areaViewport = new AreaViewport();
        Pane statusViewport = new StatusViewport();

        //this.add(areaViewport);
        //this.add(statusViewport);
    }

    @Override
    protected void render() {
        //areaViewport.repaint();
        //statusViewport.repaint();
    }

    @Override
    public void update() { }

    @Override
    public void close() { }


}
