package view.components;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class AreaViewport extends JPanel {

    private List<List<Rectangle>> tiles = new ArrayList<>();

    public AreaViewport(){
        List<Rectangle> rectList = new ArrayList<>();
        rectList.add(new Rectangle());
        tiles.add(rectList);
    }

    /*@Override
    protected void paintComponent(Grahics g) {
        super.paintComponent(g);//do I need this???
        Graphics2D g2 = (Graphics2D) g;
        for(List<Rectangle> row : tiles){
            for(Rectangle tile: row){
                g2.draw(tile);
            }
        }
    }*/
}
