package view;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public abstract class View {
    private final int VERT_RES;
    private final int HORIZ_RES;

    protected View(){
    	// protected construtor for view
    	// uses toolkit to get resolution of the device that it is running on
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	this.VERT_RES = screenSize.height;
      	this.HORIZ_RES = screenSize.width;
    }

    public abstract boolean start();

    protected abstract boolean render();

    public abstract boolean update();

    public abstract boolean close();
}
