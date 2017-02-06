package view.components;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class TilePanel extends JPanel {

    private BufferedImage tileImage;
    private Rectangle bounds;

    private static final int TILE_WIDTH = 200;
    private static final int TILE_HEIGHT = 200;

    public TilePanel(String filename) {

        //Make tile is displayed at right size
        setPreferredSize(new Dimension(TILE_WIDTH,TILE_HEIGHT));

        //Make bgrd not show
        setOpaque(false);

        //Create tile borders
        Color highlightOuter = new Color(69, 69, 69);
        Color highlightInner = new Color(0, 0, 0);
        Color shadowOuter = new Color(175, 175, 175);
        Color shadowInner = new Color(255, 255, 255);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, highlightOuter, highlightInner, shadowOuter, shadowInner));

        //Get image
        try {
            String currentDir = "file:///" + System.getProperty("user.dir").toString().replace("\\", "/");
            BufferedImage rawImage  = ImageIO.read(new URL(currentDir + "/" + filename));

            tileImage = new BufferedImage(TILE_WIDTH, TILE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
            Graphics2D tileImageGraphics = tileImage.createGraphics();
            tileImageGraphics.drawImage(rawImage, 0, 0, TILE_WIDTH, TILE_HEIGHT, null);
            tileImageGraphics.dispose();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(tileImage, 0, 0, TILE_WIDTH, TILE_HEIGHT, null);
    }
}

