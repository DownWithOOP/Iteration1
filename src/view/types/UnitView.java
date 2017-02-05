package view.types;

import view.View;
import javax.swing.*;
import java.awt.*;

public class UnitView extends View  {


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
        g.drawString("Unit View!!!",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.8));
        g.drawString("1) Return to MainView",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.5));

    }


    protected void render() {

    }


    public void update() {

    }

    public void close() {

    }

}