package view.types;

import model.common.GraphicsInfo;

import view.View;
import view.components.AreaViewport;
import view.components.StatusViewport;

import javax.swing.*;
import java.awt.*;

public class MainView extends View {

    //Need to find out about Image type; just put int in for now
    java.util.Map<GraphicsInfo, Integer> graphicsBuffer;

    View areaViewport;
    View statusViewport;

    //Temporary
    JLabel testName = new JLabel("Main view");
    JTextField testTyping = new JTextField(300);

    public MainView(){
        super();
        start();
    }

    public MainView(LayoutManager layoutManager){
        super(layoutManager);
        start();
    }

    @Override
    public void start() {
        setBackground(Color.black);

        JPanel areaViewport = new AreaViewport();
        JPanel statusViewport = new StatusViewport();

        System.out.print("Main View startingggggggggggggggggggg\ngggggggg\ng\ng\ng\ng\ng.");

        this.add(testName);
        this.add(testTyping);
        this.add(areaViewport);
        this.add(statusViewport);
    }

    @Override
    protected void render() {
        areaViewport.repaint();
        statusViewport.repaint();
    }

    @Override
    public void update() {
        setVisible(true);
    }

    @Override
    public void close() { }



}
