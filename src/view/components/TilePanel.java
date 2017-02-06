package view.components;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TilePanel extends JPanel {

    private BufferedImage tileImage;
    private Rectangle bounds;

    private static final int TILE_WIDTH = 200;
    private static final int TILE_HEIGHT = 200;

    public TilePanel(String filename) {

        setPreferredSize(new Dimension(TILE_WIDTH,TILE_HEIGHT));
        setOpaque(false);

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

