package view.types;

import model.common.RenderObject;
import model.entity.structure.Structure;
import view.View;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StructureView extends View  {

    private RenderObject renderInfo;
    private ArrayList<Structure> structures;

    public StructureView(RenderObject initialRenderInfo){
        this.renderInfo = initialRenderInfo;
        this.structures = this.renderInfo.getPlayer().getStructures(); // we get a list of all of the structures for the current player
    }
    public void setFrame(){

    }
    private Graphics g;

    public void start() {

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.g = g;
        Toolkit tool = Toolkit.getDefaultToolkit();
        Image image = tool.getImage("res/images/Space2Cat.jpg");
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.05)));
        g.setColor(Color.WHITE);
        g.drawString("-Structure View-",(int)(super.getWidth()*0.3),(int)(super.getHeight()*0.1));
        g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.01)));
        g.drawString("1) Return to MainView",(int)(super.getWidth()*0.05),(int)(super.getHeight()*0.1));
        g.drawString("2) Do Something",(int)(super.getWidth()*0.05),(int)(super.getHeight()*0.12));
        g.drawString("3) Do Something",(int)(super.getWidth()*0.05),(int)(super.getHeight()*0.14));
        g.drawString("3) Do Something",(int)(super.getWidth()*0.05),(int)(super.getHeight()*0.16));
        g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.02)));
        g.drawString("Structure#",(int)(super.getWidth()*0.3),(int)(super.getHeight()*0.2));
        g.drawString("Stats",(int)(super.getWidth()*0.45),(int)(super.getHeight()*0.2));
        g.drawString("Missions",(int)(super.getWidth()*0.7),(int)(super.getHeight()*0.2));
        g.drawString(this.structures.toString(), 100,100);

        // max 10 structures to display
        for(int i=1; i<11; i++){
            int add = (int)(0.07*i*super.getHeight());
            g.drawString("#" +i,(int)(super.getWidth()*0.3),(int)(super.getHeight()*0.23 + add));
        }
        for(int i=1; i<11; i++){
            int add = (int)(0.07*i*super.getHeight());
            g.drawString("Stats",(int)(super.getWidth()*0.45),(int)(super.getHeight()*0.23 + add));
        }
        for(int i=1; i<11; i++){
            int add = (int)(0.07*i*super.getHeight());
            g.drawString("Mission",(int)(super.getWidth()*0.7),(int)(super.getHeight()*0.23 + add));
        }
    }

    protected void render() {
        // this method takes everything that is in a table and draws it

    }


    public void update() {

    }

    public void close() {

    }

}