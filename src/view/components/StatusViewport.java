package view.components;

import javax.swing.*;
import java.awt.*;

public class StatusViewport extends JPanel {
    public StatusViewport(){
        setOpaque(false);
        setPreferredSize(new Dimension(250,500));
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

}