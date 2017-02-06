package view.types;

import view.View;
import javax.swing.*;
import java.awt.*;

public class PauseView extends View  {
    
    public void start() {

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Toolkit tool = Toolkit.getDefaultToolkit();
        Image image = tool.getImage("res/images/PauseCat.jpg");
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.05)));
        g.setColor(Color.CYAN);
        g.drawString("Game Paused",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.2));
        g.setFont(new Font("TimesRoman", Font.BOLD, 100));
        g.drawString("m) Resume Game",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.5));
        g.drawString("u) Unit Overview",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.6));
        g.drawString("s) Structure Overview",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.7));

    }

    protected void render() {
        Graphics g = super.getGraphics();

    }


    public void update() {

    }

    public void close() {

    }

}