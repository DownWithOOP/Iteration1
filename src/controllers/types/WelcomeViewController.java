package controllers.types;

import controllers.Controller;
import controllers.StateManager;
import controllers.TypeOfControllers;
import view.View;
import view.types.WelcomeView;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

/**
 * Created by jordi on 2/1/2017.
 */
public class WelcomeViewController extends Controller {

    private WelcomeView welcomeView;

    public WelcomeViewController(StateManager stateManager) {
        super(stateManager);
    }

    @Override
    public void update() {

    }
    protected void handleKeyPressed(KeyEvent e) {
        System.out.println("=================================== Welcome View Controller event handler");

        System.out.println(e.toString());

    }

    protected void initializeWelcomeViewController() {

    }

    @Override
    protected void setView() {
        this.welcomeView = new WelcomeView(); // the welcome view is initialized
    }

    protected void setWelcomeViewActions() {

    }

    @Override
    protected void updateView() {

    }

    @Override
    public View returnViewToStateManager() {
        return this.welcomeView;
    }

}
