package view.components;

import javax.swing.*;
import java.awt.*;

public class StatusViewport extends JPanel {
    public StatusViewport(Rectangle bounds){
        setOpaque(false);
        setPreferredSize(new Dimension((int)bounds.getWidth(),(int)bounds.getHeight()));
        setBorder(BorderFactory.createLineBorder(Color.black, 50));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);//do I need this??? IDK
        System.out.println("PAINTING STATUS VIEWPORT");
    }
}