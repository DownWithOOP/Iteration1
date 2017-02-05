package view.utilities;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

/**
 * Created by cduica on 2/4/17.
 */
public class Assets {

    ImageLoader imageLoader;

    /**
     * Singleton for all the single ladies
     */
    private static Assets assets = new Assets();

    public static Assets getInstance() {
        return assets;
    }

    private Assets() {
        imageLoader = new ImageLoader();
        if(init()){
            System.out.println("Assets loaded successfully");
        } else {
            System.out.println("Failed to load assets");
        }
    }

    /**
     * Image assets
     */

    public BufferedImage CATFOOD;
    public BufferedImage CRYSTAL;
    public BufferedImage RESEARCH;

    public BufferedImage DIRT;
    public BufferedImage CRATER;
    public BufferedImage GRASS;
    public BufferedImage WATER;

    public BufferedImage RED_CROSS;
    public BufferedImage SKULL;

    public BufferedImage BASE;

    public BufferedImage COLONIST;
    public BufferedImage EXPLORER;
    public BufferedImage MELEE;
    public BufferedImage RANGED;

    public boolean init(){

        try {

            //resources
            CATFOOD = imageLoader.loadImageFromPath("/images/catfood.png");
            CRYSTAL = imageLoader.loadImageFromPath("/images/crystal.png");
            RESEARCH = imageLoader.loadImageFromPath("/images/research.png");

            //terrain
            DIRT = imageLoader.loadImageFromPath("/images/dirt.png");
            CRATER = imageLoader.loadImageFromPath("/images/crater.png");
            GRASS = imageLoader.loadImageFromPath("/images/grass.png");
            WATER = imageLoader.loadImageFromPath("/images/water.png");

            //decals
            RED_CROSS = imageLoader.loadImageFromPath("/images/redcross.png");
            SKULL = imageLoader.loadImageFromPath("/images/skyll.png");

            //structures
            BASE = imageLoader.loadImageFromPath("/images/base.png");

            //units
            COLONIST = imageLoader.loadImageFromPath("/images/colonist.png");
            EXPLORER = imageLoader.loadImageFromPath("/images/explorer.png");
            MELEE = imageLoader.loadImageFromPath("/images/melee.png");
            RANGED = imageLoader.loadImageFromPath("/images/ranged.png");
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
