package view.types;

import javafx.scene.layout.Pane;
import model.common.GraphicsInfo;

import view.View;
import view.components.AreaViewport;
import view.components.StatusViewport;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainView extends View implements KeyListener {

    //Need to find out about Image type; just put int in for now
    java.util.Map<GraphicsInfo, Integer> graphicsBuffer;

    View areaViewport;
    View statusViewport;

    public MainView(){
        super.addKeyListener(this);
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        System.out.println(" MAIN VIEW KEYBOARD INPUT!!!!!!!!!!!!!!");
    }

    public void keyReleased(KeyEvent e) {
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
