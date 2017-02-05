

package view.types;

import javax.swing.*;
import java.awt.*;
import javafx.scene.layout.Pane;
import view.View;


public class MainView extends View {


    public MainView(){

    }

    @Override
    public void start() {

    }

    @Override
    protected void render() {

    }

    @Override
    public void update() {

    }

    @Override
    public void close() {

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
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