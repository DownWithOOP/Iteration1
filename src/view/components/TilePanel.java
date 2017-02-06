package view.components;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class TilePanel extends JPanel {

    private BufferedImage tileImage;
    private BufferedImage entityImage;
    private Rectangle bounds;

    private final int tileWidth;
    private final int tileHeight;

    private final int entityWidth;
    private final int entityHeight;
    private final int entityBorder;

    public TilePanel(String filePath, int tileWidth, int tileHeight) {
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;

        entityBorder = (int)0.1 * tileWidth;
        entityWidth = tileWidth - entityBorder;
        entityHeight = tileHeight - entityBorder;

        //Make tile is displayed at right size
        setPreferredSize(new Dimension(tileWidth,tileHeight));

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
            tileImage = readAndResizeImage(filePath, tileWidth, tileHeight);
        }
        catch (IOException e){
            tileImage = new BufferedImage(tileWidth, tileHeight, BufferedImage.TYPE_INT_ARGB);
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

        System.out.println(tileWidth + "," + tileHeight);
        g.drawImage(tileImage, 0, 0, tileWidth, tileHeight, null);
        g.drawImage(entityImage, 0, 0, entityWidth, entityHeight, null);
    }

    public void addEntityImage(String filePath) {
        entityImage = null;
        //Get image
        try {
            entityImage = readAndResizeImage(filePath, entityWidth, entityHeight);
        }
        catch (IOException e){
            entityImage = new BufferedImage(tileWidth, tileHeight, BufferedImage.TYPE_INT_ARGB);
            System.out.println(e.getMessage());
        }
    }
}

