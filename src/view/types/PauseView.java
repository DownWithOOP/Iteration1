package view.types;

import view.View;
import javax.swing.*;
import java.awt.*;

public class PauseView extends View  {


    public void WelcomeView(){

    }
    public void setFrame(){

    }


    public void start() {

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("TimesRoman", Font.BOLD, 200));
        g.setColor(Color.BLACK);
        g.drawString("Pause View!!!",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.8));
        g.setFont(new Font("TimesRoman", Font.BOLD, 100));
        g.drawString("1) Resume",(int)(super.getWidth()*0.7),(int)(super.getHeight()*0.5));
        g.drawString("2) Options",(int)(super.getWidth()*0.7),(int)(super.getHeight()*0.6));
        g.drawString("3) Stuff",(int)(super.getWidth()*0.7),(int)(super.getHeight()*0.7));
        g.drawString("4) Exit",(int)(super.getWidth()*0.7),(int)(super.getHeight()*0.8));

    }


    protected void render() {

    }


    public void update() {

    }

    public void close() {

    }

}