package view.types;

import model.common.RenderObject;
import model.entity.unit.Unit;
import view.View;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UnitView extends View  {

    private RenderObject renderInfo;
    private ArrayList<Unit> units;
    public UnitView(RenderObject initialRenderInfo){
        this.renderInfo = initialRenderInfo;
        this.units = this.renderInfo.getPlayer().getUnits();
    }
    public void setFrame(){

    }


    public void start() {

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Toolkit tool = Toolkit.getDefaultToolkit();
        Image image = tool.getImage("res/images/Tiger3.png");
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.05)));
        g.setColor(Color.WHITE);
        g.drawString("-Unit View-",(int)(super.getWidth()*0.3),(int)(super.getHeight()*0.1));
        g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.01)));
        g.drawString("1) Return to MainView",(int)(super.getWidth()*0.05),(int)(super.getHeight()*0.1));
        g.drawString("2) Do Something",(int)(super.getWidth()*0.05),(int)(super.getHeight()*0.12));
        g.drawString("3) Do Something",(int)(super.getWidth()*0.05),(int)(super.getHeight()*0.14));
        g.drawString("3) Do Something",(int)(super.getWidth()*0.05),(int)(super.getHeight()*0.16));
        g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.02)));
        g.drawString("Explorer Units ----",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.2));
        g.drawString("Colonist Units ----",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.4));
        g.drawString("Melee Units -------",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.6));
        g.drawString("Ranged Units ------",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.8));
        g.drawString(units.toString(), 100,100);


    }


    protected void render() {

    }


    public void update() {

    }

    public void close() {

    }

}