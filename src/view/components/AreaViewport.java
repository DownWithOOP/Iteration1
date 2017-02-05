package view.components;

import model.map.Map;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AreaViewport extends JPanel {

    private List<List<Rectangle>> tiles = new ArrayList<>();

    public AreaViewport(){
        List<Rectangle> rectList = new ArrayList<>();
        rectList.add(new Rectangle());
        tiles.add(rectList);
    }

    public void update(Map map){

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);//do I need this???
        Graphics2D g2 = (Graphics2D) g;
        for(List<Rectangle> row : tiles){
            for(Rectangle tile: row){
                g2.draw(tile);
            }
        }
        System.out.println("PAINTING AREA VIEWPORT");
    }
}
