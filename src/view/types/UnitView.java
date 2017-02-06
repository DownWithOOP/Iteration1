package view.types;

import model.common.RenderObject;
import model.entity.unit.*;
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
        g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.04)));
        g.setColor(Color.WHITE);
        g.drawString("-Unit View-",(int)(super.getWidth()*0.1),(int)(super.getHeight()*0.1));
        g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.01)));
        g.drawString("m) Return to MainView",(int)(super.getWidth()*0.75),(int)(super.getHeight()*0.07));
        g.drawString("2) Assemble Army (TODO)",(int)(super.getWidth()*0.75),(int)(super.getHeight()*0.09));
        g.drawString("3) Disband Army (TODO)",(int)(super.getWidth()*0.75),(int)(super.getHeight()*0.11));
        g.drawString("Number of Units: "+units.size(),(int)(super.getWidth()*0.35),(int)(super.getHeight()*0.07));
        g.drawString("Number of Armies: "+this.renderInfo.getPlayer().getArmies().size(),(int)(super.getWidth()*0.5),(int)(super.getHeight()*0.07));
        g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.02)));
        g.drawString("Explorer Units --------------------------------------------------------------------------",(int)(super.getWidth()*0.05),(int)(super.getHeight()*0.2));
        g.drawString("Colonist Units --------------------------------------------------------------------------",(int)(super.getWidth()*0.05),(int)(super.getHeight()*0.4));
        g.drawString("Melee Units -----------------------------------------------------------------------------",(int)(super.getWidth()*0.05),(int)(super.getHeight()*0.6));
        g.drawString("Ranged Units ----------------------------------------------------------------------------",(int)(super.getWidth()*0.05),(int)(super.getHeight()*0.8));


        int explorerCount = 1;
        int colonistCount = 1;
        int meleeCount = 1;
        int rangedCount = 1;

        g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.01)));

        for(int i=0; i<units.size(); i++){
            // we itterate over all the units in the arrayList
            Unit temp = units.get(i);
            if(temp instanceof Explorer){
                g.drawString("Explorer# "+(explorerCount+1)/2,(int)(super.getWidth()*0.04*explorerCount),(int)(super.getHeight()*0.23));
                g.drawString("O-Damage: "+temp.getUnitStats().getOffensiveDamage(),(int)(super.getWidth()*0.04*explorerCount),(int)(super.getHeight()*0.25));
                g.drawString("D-Damage: "+temp.getUnitStats().getDefensiveDamage(),(int)(super.getWidth()*0.04*explorerCount),(int)(super.getHeight()*0.27));
                g.drawString("Armor: "+temp.getUnitStats().getArmor(),(int)(super.getWidth()*0.04*explorerCount),(int)(super.getHeight()*0.29));
                g.drawString("Movement: "+temp.getUnitStats().getMovement(),(int)(super.getWidth()*0.04*explorerCount),(int)(super.getHeight()*0.31));
                g.drawString("Health: "+temp.getUnitStats().getHealth(),(int)(super.getWidth()*0.04*explorerCount),(int)(super.getHeight()*0.33));
                g.drawString("Upkeep: "+temp.getUnitStats().getHealth(),(int)(super.getWidth()*0.04*explorerCount),(int)(super.getHeight()*0.35));
                explorerCount +=2;
            }
            else if(temp instanceof Colonist){
                g.drawString("Colonist# "+(colonistCount+1)/2,(int)(super.getWidth()*0.04*colonistCount),(int)(super.getHeight()*0.43));
                g.drawString("O-Damage: "+temp.getUnitStats().getOffensiveDamage(),(int)(super.getWidth()*0.04*colonistCount),(int)(super.getHeight()*0.45));
                g.drawString("D-Damage: "+temp.getUnitStats().getDefensiveDamage(),(int)(super.getWidth()*0.04*colonistCount),(int)(super.getHeight()*0.47));
                g.drawString("Armor: "+temp.getUnitStats().getArmor(),(int)(super.getWidth()*0.04*colonistCount),(int)(super.getHeight()*0.49));
                g.drawString("Movement: "+temp.getUnitStats().getMovement(),(int)(super.getWidth()*0.04*colonistCount),(int)(super.getHeight()*0.51));
                g.drawString("Health: "+temp.getUnitStats().getHealth(),(int)(super.getWidth()*0.04*colonistCount),(int)(super.getHeight()*0.53));
                g.drawString("Upkeep: "+temp.getUnitStats().getHealth(),(int)(super.getWidth()*0.04*colonistCount),(int)(super.getHeight()*0.55));
                colonistCount +=2;
            }
            else if(temp instanceof Melee){
                g.drawString("MeleeUnit# "+(colonistCount+1)/2,(int)(super.getWidth()*0.04*meleeCount),(int)(super.getHeight()*0.63));
                g.drawString("O-Damage: "+temp.getUnitStats().getOffensiveDamage(),(int)(super.getWidth()*0.04*meleeCount),(int)(super.getHeight()*0.65));
                g.drawString("D-Damage: "+temp.getUnitStats().getDefensiveDamage(),(int)(super.getWidth()*0.04*meleeCount),(int)(super.getHeight()*0.67));
                g.drawString("Armor: "+temp.getUnitStats().getArmor(),(int)(super.getWidth()*0.04*meleeCount),(int)(super.getHeight()*0.69));
                g.drawString("Movement: "+temp.getUnitStats().getMovement(),(int)(super.getWidth()*0.04*meleeCount),(int)(super.getHeight()*0.71));
                g.drawString("Health: "+temp.getUnitStats().getHealth(),(int)(super.getWidth()*0.04*meleeCount),(int)(super.getHeight()*0.73));
                g.drawString("Upkeep: "+temp.getUnitStats().getHealth(),(int)(super.getWidth()*0.04*meleeCount),(int)(super.getHeight()*0.75));
                meleeCount +=2;
            }
            else if(temp instanceof Ranged){
                g.drawString("RangedUnit# "+(colonistCount+1)/2,(int)(super.getWidth()*0.04*rangedCount),(int)(super.getHeight()*0.83));
                g.drawString("O-Damage: "+temp.getUnitStats().getOffensiveDamage(),(int)(super.getWidth()*0.04*rangedCount),(int)(super.getHeight()*0.85));
                g.drawString("D-Damage: "+temp.getUnitStats().getDefensiveDamage(),(int)(super.getWidth()*0.04*rangedCount),(int)(super.getHeight()*0.87));
                g.drawString("Armor: "+temp.getUnitStats().getArmor(),(int)(super.getWidth()*0.04*rangedCount),(int)(super.getHeight()*0.89));
                g.drawString("Movement: "+temp.getUnitStats().getMovement(),(int)(super.getWidth()*0.04*rangedCount),(int)(super.getHeight()*0.91));
                g.drawString("Health: "+temp.getUnitStats().getHealth(),(int)(super.getWidth()*0.04*rangedCount),(int)(super.getHeight()*0.93));
                g.drawString("Upkeep: "+temp.getUnitStats().getHealth(),(int)(super.getWidth()*0.04*rangedCount),(int)(super.getHeight()*0.95));
                rangedCount +=2;
            }
        }
    }


    protected void render() {

    }


    public void update() {

    }

    public void close() {

    }

}