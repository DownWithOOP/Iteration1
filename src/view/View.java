package view;
import javax.swing.*;
import java.awt.*;


public abstract class View {

    public abstract void start();

    protected abstract void render();

    public abstract void update();

    public abstract void close();
}
