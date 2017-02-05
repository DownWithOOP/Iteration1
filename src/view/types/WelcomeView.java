package view.types;

import java.awt.*;
import view.View;

import javax.swing.*;


/**
 * Created by Konrad on 2/2/2017.
 */
public class WelcomeView extends View {

    public WelcomeView() {
        super();
    }

    public WelcomeView(LayoutManager layoutManager){
        super(layoutManager);
    }

    @Override
    public void start() {
        setBackground(Color.black);
    }

    @Override
    protected void render() {

    }

    @Override
    public void update() {

    }

    @Override
    public void close() {

    }

}
