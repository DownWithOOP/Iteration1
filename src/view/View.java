package view;


public abstract class View {

    protected View(){

        }

    public abstract void start();

    protected abstract void render();

    public abstract void update();

    public abstract void close();
}
