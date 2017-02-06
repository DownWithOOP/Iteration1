package view.types;

import model.common.RenderObject;
import model.entity.structure.Base;
import model.entity.structure.Structure;
import view.View;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
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
        g.setColor(Color.CYAN);
        g.drawString("-Structure View-",(int)(super.getWidth()*0.1),(int)(super.getHeight()*0.1));
        g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.01)));
        g.drawString("m) Return to MainView",(int)(super.getWidth()*0.85),(int)(super.getHeight()*0.06));
        g.drawString("2) Group (TODO)",(int)(super.getWidth()*0.85),(int)(super.getHeight()*0.08));
        g.drawString("3) Un-Group (TODO)",(int)(super.getWidth()*0.85),(int)(super.getHeight()*0.10));
        g.drawString("3) Do Something",(int)(super.getWidth()*0.85),(int)(super.getHeight()*0.12));
        g.drawString("Number of Structures: " +this.structures.size(),(int)(super.getWidth()*0.60),(int)(super.getHeight()*0.10));
        g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.02)));
        g.drawString("Structure#",(int)(super.getWidth()*0.1),(int)(super.getHeight()*0.19));
        g.drawString("Stats",(int)(super.getWidth()*0.25),(int)(super.getHeight()*0.19));
        g.drawString("Missions",(int)(super.getWidth()*0.7),(int)(super.getHeight()*0.19));
        Graphics2D g2 = (Graphics2D) g;
        Stroke stroke = new BasicStroke(10);
        g2.setStroke(stroke);
        g2.draw(new Line2D.Double((int)(super.getWidth()*0.1), (int)(super.getHeight()*0.15), (int)(super.getWidth()*0.9), (int)(super.getHeight()*0.15)));
        g2.draw(new Line2D.Double((int)(super.getWidth()*0.1), (int)(super.getHeight()*0.21), (int)(super.getWidth()*0.9), (int)(super.getHeight()*0.21)));
        // max 10 structures to display
        int baseCount = 1;
        g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.01)));
        for(int i=1; i<this.structures.size()+1; i++){
            int add = (int)(0.07*i*super.getHeight());
            if(this.structures.get(i-1) instanceof Base){
                g.drawString("Base#" +i,(int)(super.getWidth()*0.12),(int)(super.getHeight()*0.18 + add));
            }

        }
        for(int i=1; i<this.structures.size()+1; i++){
            int add = (int)(0.07*i*super.getHeight());
            Structure temp = this.structures.get(i-1);
            g.drawString("",(int)(super.getWidth()*0.25),(int)(super.getHeight()*0.18 + add));
            g.drawString("O-Damage: "+temp.getStructureStats().getOffensiveDamage(),(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.17 + add));
            g.drawString("D-Damage: "+temp.getStructureStats().getDefensiveDamage(),(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.19 + add));
            g.drawString("Armor: "+temp.getStructureStats().getArmor(),(int)(super.getWidth()*0.3),(int)(super.getHeight()*0.17 + add));
            g.drawString("Production %: "+temp.getStructureStats().getProductionRates(),(int)(super.getWidth()*0.3),(int)(super.getHeight()*0.19 + add));
            g.drawString("Health: "+temp.getStructureStats().getHealth(),(int)(super.getWidth()*0.4),(int)(super.getHeight()*0.17 + add));
            g.drawString("Upkeep: "+temp.getStructureStats().getUpkeep(),(int)(super.getWidth()*0.4),(int)(super.getHeight()*0.19 + add));
            g2.draw(new Line2D.Double((int)(super.getWidth()*0.1), (int)(super.getHeight()*0.21+add), (int)(super.getWidth()*0.9), (int)(super.getHeight()*0.21+add)));
        }
        for(int i=1; i<this.structures.size()+1; i++){
            int add = (int)(0.07*i*super.getHeight());
            g.drawString("Mission",(int)(super.getWidth()*0.7),(int)(super.getHeight()*0.18 + add));
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