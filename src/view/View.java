package view;

import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.WindowEvent;

public abstract class View extends Scene{
    protected boolean guiInitialized; //TODO Decide if we need this

    protected View(Parent root){
    	super(root); // create GUI
    	System.out.println("ABSTRACT VIEW CLASS IS INITIALIZED");
    	// protected constructor for view
    	Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
      	this.guiInitialized = true;
    }

    public abstract void start();

    protected abstract void render();

    public abstract void update();

    public abstract void close();
}
