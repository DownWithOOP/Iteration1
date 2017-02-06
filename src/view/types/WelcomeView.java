package view.types;

import view.View;
import javax.swing.*;
import java.awt.*;

public class WelcomeView extends View  {


    public void WelcomeView(){

    }
    public void setFrame(){

    }


    public void start() {

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Toolkit tool = Toolkit.getDefaultToolkit();
        Image image = tool.getImage("res/images/SpaceCat.jpg");
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.05)));
        g.setColor(Color.CYAN);
        g.drawString("Space Cats",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.8));
        g.setFont(new Font("TimesRoman", Font.BOLD, 60));
        g.drawString("m) Main View ",(int)(super.getWidth()*0.7),(int)(super.getHeight()*0.5));
        g.drawString("p) Pause View",(int)(super.getWidth()*0.7),(int)(super.getHeight()*0.6));
        g.drawString("u) UnitSubview",(int)(super.getWidth()*0.7),(int)(super.getHeight()*0.7));
        g.drawString("s) StructureOverview",(int)(super.getWidth()*0.7),(int)(super.getHeight()*0.8));
        g.drawString("v0.01578.32 pre-alpha",(int)(super.getWidth()*0.1),(int)(super.getHeight()*0.9));
    }


    protected void render() {

    }


    public void update() {

    }

    public void close() {

    }

}