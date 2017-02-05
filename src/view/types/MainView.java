

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
        Toolkit tool = Toolkit.getDefaultToolkit();
        Image image = tool.getImage("res/images/background1.jpg");
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.05)));
        g.setColor(Color.WHITE);
        g.drawString("-Main View-",(int)(super.getWidth()*0.3),(int)(super.getHeight()*0.1));
        g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.01)));
        g.drawString("1) Pause",(int)(super.getWidth()*0.05),(int)(super.getHeight()*0.1));
        g.drawString("2) Structure OverView",(int)(super.getWidth()*0.05),(int)(super.getHeight()*0.12));
        g.drawString("3) Unit Overview",(int)(super.getWidth()*0.05),(int)(super.getHeight()*0.14));
        g.drawString("4) Exit",(int)(super.getWidth()*0.05),(int)(super.getHeight()*0.16));
    }


}