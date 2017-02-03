package view;

import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public abstract class View extends Stage{
    protected boolean guiInitialized;

    protected View(){
    	super(); // create GUI
    	System.out.println("ABSTRACT VIEW CLASS IS INITIALIZED");
    	// protected constructor for view
    	Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    	this.setX((int)primaryScreenBounds.getMinX());
		this.setY((int)primaryScreenBounds.getMinY());
      	this.guiInitialized = true;
		this.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				System.out.println("Stage is closing");
			}
            });
        }

    public abstract void start();

    protected abstract void render();

    public abstract void update();

    public abstract void close();
}
