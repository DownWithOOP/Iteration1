package controllers.types;

import controllers.Controller;
import controllers.StateManager;
import controllers.TypeOfControllers;
import view.types.WelcomeView;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

/**
 * Created by jordi on 2/1/2017.
 */
public class WelcomeViewController extends Controller {
    private final WelcomeView welcomeView = new WelcomeView(new BorderLayout());

    public WelcomeViewController(StateManager stateManager) {
        super(stateManager);
        setView();
    }

    @Override
    public void update() {

    }
    protected void handleKeyPressed(KeyEvent e) {
        System.out.println("=================================== Welcome View Controller event handler");

        System.out.println(e.toString());

    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void setView() {
        super.view = welcomeView;
    }

    @Override
    protected void setControllerActions() {

    }

    @Override
    protected void updateView() {

    }
}
