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
    private BufferedImage entityImage;
    private Rectangle bounds;

    private static final int TILE_WIDTH = 200;
    private static final int TILE_HEIGHT = 200;
    private static final int ENTITY_WIDTH = TILE_WIDTH - 50;
    private static final int ENTITY_HEIGHT = TILE_HEIGHT - 50;

    public TilePanel(String filePath) {

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
            tileImage = readAndResizeImage(filePath, TILE_WIDTH, TILE_HEIGHT);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private BufferedImage readAndResizeImage(String filename, int newWidth, int newHeight) throws IOException{
        String currentDir = "file:///" + System.getProperty("user.dir").toString().replace("\\", "/");
        BufferedImage rawImage  = ImageIO.read(new URL(currentDir + "/" + filename));

        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D tileImageGraphics = resizedImage.createGraphics();
        tileImageGraphics.drawImage(rawImage, 0, 0, newWidth, newHeight, null);
        tileImageGraphics.dispose();

        return resizedImage;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(tileImage, 0, 0, TILE_WIDTH, TILE_HEIGHT, null);
        g.drawImage(tileImage, 0, 0, ENTITY_WIDTH, ENTITY_HEIGHT, null);
    }

    public void addEntityImage(String filePath) {
        //Get image
        try {
            entityImage = readAndResizeImage(filePath, ENTITY_WIDTH, ENTITY_HEIGHT);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

