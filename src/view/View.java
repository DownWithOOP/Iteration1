package view;
import javax.swing.JPanel;
import java.awt.LayoutManager;

public abstract class View extends JPanel{

    protected View(){
        super();
    }
    protected View(LayoutManager layoutManager){
        super(layoutManager);
    }

    public abstract void start();

    protected abstract void render();

    public abstract void update();

    public abstract void close();
}
