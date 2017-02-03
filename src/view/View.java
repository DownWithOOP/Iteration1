package view;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public abstract class View extends Frame {

    private int screenHeight;
    private int screenWidth;

    protected View(){
                super("Space Cats");
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                screenHeight = screenSize.height;
                screenWidth = screenSize.width;

                setSize(screenWidth,screenHeight);
                addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent windowEvent){
                        System.exit(0);
                    }
                });
                this.setVisible(true);
    }

    public abstract void start();

    protected abstract void render();

    public abstract void update();

    public abstract void close();
}
