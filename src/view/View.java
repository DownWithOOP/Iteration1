package view;

public abstract class View {
    final int VERT_RES=0;
    final int HORIZ_RES=0;
//    TODO: check the variables above and make sure to give them the right values

    protected View(){

    }

    public abstract boolean start();

    protected abstract boolean render();

    public abstract boolean update();

    public abstract boolean close();
}