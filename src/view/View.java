package view;
import javax.swing.*;

public abstract class View extends JPanel{

    public abstract void start();

    protected abstract void render();

    public abstract void update();

    public abstract void close();
}
