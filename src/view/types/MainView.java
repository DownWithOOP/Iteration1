package view.types;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

import model.common.Location;
import model.common.RenderObject;
import model.map.Map;
import model.player.Player;
import org.w3c.dom.css.Rect;
import view.View;
import view.components.AreaViewport;
import view.components.StatusViewport;


public class MainView extends View {

    private AreaViewport areaViewport;
    private StatusViewport statusViewport;

    public MainView(GridBagLayout layout, RenderObject initialRenderInfo, int width, int height) {
        super(layout);
        setOpaque(false);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1;

        Rectangle statusBounds = new Rectangle(width / 2, height);

        statusViewport = new StatusViewport(new GridBagLayout(), statusBounds, initialRenderInfo.getPlayer());
        constraints.weightx = 0.15;
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(statusViewport, constraints);

        Rectangle areaBounds = new Rectangle(width / 2, height);

        areaViewport = new AreaViewport(new GridBagLayout(), areaBounds, initialRenderInfo.getMap(), initialRenderInfo.getPlayer().getPlayerLocation());
        constraints.weightx = 0.85;
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(areaViewport, constraints);
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

    public void update(RenderObject renderInfo) {
        areaViewport.update(renderInfo.getMap(), renderInfo.getPlayer().getPlayerLocation());
        //statusViewport.update(player);
    }

    @Override
    public void close() {

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        areaViewport.paintComponent(g);
        statusViewport.paintComponent(g);

        //g.setFont(new Font("TimesRoman", Font.BOLD, 200));
        g.setColor(Color.BLACK);
        Toolkit tool = Toolkit.getDefaultToolkit();
        Image image = tool.getImage("res/images/background1.jpg"); //TODO wrap file opening in try catch
        g.drawImage(image, 0, 0, this);
        //g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.05)));
        //g.setColor(Color.WHITE);
//
        //g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.01)));
        //g.drawString("-Main View-",(int)(super.getWidth()*0.03),(int)(super.getHeight()*0.08));
        //g.drawString("1) Pause",(int)(super.getWidth()*0.03),(int)(super.getHeight()*0.12));
        //g.drawString("2) Structure OverView",(int)(super.getWidth()*0.03),(int)(super.getHeight()*0.14));
        //g.drawString("3) Unit Overview",(int)(super.getWidth()*0.03),(int)(super.getHeight()*0.16));
        //g.drawString("4) Exit",(int)(super.getWidth()*0.03),(int)(super.getHeight()*0.18));
//
        //g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.06)));
        //g.drawString("Larry if you are reading ",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.8));
        //g.drawString("this, get to work",(int)(super.getWidth()*0.2),(int)(super.getHeight()*0.9));
//
        //// vertical line to the left
        //Graphics2D g2 = (Graphics2D) g;
        //Line2D line = new Line2D.Double(
        //(int)(super.getWidth()*0.15),
        //0,
        //(int)(super.getWidth()*0.15),
        //(int)(super.getHeight()));
        //g2.setStroke(new BasicStroke(10));
        //g2.draw(line);
//
        //// small horizontal line
        //Line2D line2 = new Line2D.Double(
        //0,
        //(int)(super.getHeight())*0.23,
        //(int)(super.getWidth()*0.15),
        //(int)(super.getHeight())*0.23);
        //g2.draw(line2);
//
        //g.setFont(new Font("TimesRoman", Font.BOLD, (int)(super.getWidth()*0.01)));
        //g.drawString("-Status ViewPort-",(int)(super.getWidth()*0.03),(int)(super.getHeight()*0.27));
//
        //g.drawString("-Area ViewPort-",(int)(super.getWidth()*0.45),(int)(super.getHeight()*0.05));
//
    }
}

