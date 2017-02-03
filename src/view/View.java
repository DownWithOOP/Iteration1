package view;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public abstract class View extends Frame{
    protected boolean guiInitialized;
    private final int VERT_RES;
    private final int HORIZ_RES;

    protected View(){
    	super("Space Cats"); // create GUI 
    	System.out.println("ABSTRACT CLASS IS INITLIAZED");
    	// protected construtor for view
    	// uses toolkit to get resolution of the device that it is running on
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	this.VERT_RES = screenSize.height;
      	this.HORIZ_RES = screenSize.width;
      	this.guiInitialized = true;

      	setSize(this.HORIZ_RES,this.VERT_RES);
     		 addWindowListener(new WindowAdapter() {
     		 	// event handler so when the game is closed, program stops
         		public void windowClosing(WindowEvent windowEvent){
           		 System.exit(0);
        	 }        
      	}); 
     	this.setVisible(true);
    }

    public abstract boolean start();

    protected abstract boolean render();

    public abstract boolean update();

    public abstract boolean close();
}
