package view.utilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Created by cduica on 2/4/17.
 */
public class ImageLoader {

    public BufferedImage loadImageFromPath(String path) throws Exception{

        return ImageIO.read(getClass().getResourceAsStream(path));

    }

}
