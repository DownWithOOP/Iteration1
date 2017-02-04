package view.types;

import javax.swing.*;
import java.awt.*;
import javafx.scene.layout.Pane;
import model.common.GraphicsInfo;

import view.View;
import view.components.AreaViewport;
import view.components.StatusViewport;

public class MainView extends JPanel {

    //Need to find out about Image type; just put int in for now
    java.util.Map<GraphicsInfo, Integer> graphicsBuffer;

    View areaViewport;
    View statusViewport;

    public MainView(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        System.out.println("------------------!!!!!!!!!!!!!!!!");
        g.setFont(new Font("TimesRoman", Font.BOLD, 200));
        g.setColor(Color.BLACK);
        g.drawString("Main View!!! HURRAH",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.8));
        g.setFont(new Font("TimesRoman", Font.BOLD, 50));
        g.setColor(Color.BLACK);
        g.drawString("1) Pause View",(int)(super.getWidth()*0.7),(int)(super.getHeight()*0.2));
        g.drawString("2) Structure Overview",(int)(super.getWidth()*0.7),(int)(super.getHeight()*0.3));
        g.drawString("3) Unit Overview",(int)(super.getWidth()*0.7),(int)(super.getHeight()*0.4));
        g.drawString(" ^ not yet working",(int)(super.getWidth()*0.7),(int)(super.getHeight()*0.5));
    }


}
