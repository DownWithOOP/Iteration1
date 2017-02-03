package view;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public abstract class View {


    protected View(){

    }

    public abstract void start();

    protected abstract void render();

    public abstract void update();

    public abstract void close();
}
