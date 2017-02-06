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
        g.setColor(Color.WHITE);
        g.drawString("Game Paused",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.2));
        g.setFont(new Font("TimesRoman", Font.BOLD, 100));
        g.drawString("1) Resume",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.5));
        g.drawString("2) Options (coming later)",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.6));
        g.drawString("3) Save (coming later)",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.7));
        g.drawString("4) Exit",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.8));

    }

    protected void render() {
        Graphics g = super.getGraphics();

    }


    public void update() {

    }

    public void close() {

    }

}