package controllers;

import view.GUI;
import controllers.types.gameControllers.MainViewController;
import controllers.types.gameControllers.StructureViewController;
import controllers.types.gameControllers.UnitViewController;
import controllers.types.WelcomeViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

/**
 * Created by jordi on 2/1/2017.
 */
public class StateManager implements KeyListener{


    private HashMap<TypeOfControllers, Controller> controllerMap = new HashMap<>();       //used for controller change, so that access is O(1)
    private boolean gameOn;
    public final long FPS = 30;                            //frames per second
    final long LOOP_TIME = 1000l / FPS;                   //how long an update should take 1000 miliseconds/ FPS
    private Controller activeController;
    private GUI gui;
    /**
     * when class is initialized the controllers are too and the WelcomeViewController is activated
     */
    public StateManager() { // this is where the GUI is created

        // initialize GUI here
        gui = new GUI();
        gui.frame.addKeyListener(this); // we add the keylistener and the events get handled in this class

        initializeControllers();
        activeController = controllerMap.get(TypeOfControllers.WelcomeViewController);
    }

    /**
     * game basically starts
     * //TODO:ask if needed for the first screen
     */
    private void startGameLoop() {
        while (gameOn) {
            long timeStart = System.currentTimeMillis();
            update();
            calculateLoopSleepTime(timeStart);
        }
    }

    public void startGame() {
        gameOn = true;
        startGameLoop();
    }

    /**
     * Ensures the amount of frames per second of the game
     * @param timeStart the time at which the function started
     */
    public void calculateLoopSleepTime(long timeStart) {
        long timeEnd = System.currentTimeMillis();
        long sleepTime = LOOP_TIME - (timeEnd - timeStart);
        if (sleepTime > 0) {
            try {
                System.out.println("Sleep time: " + sleepTime);
                Thread.sleep(sleepTime);
            } catch (Exception e) {
                System.err.println("fail on game loop");
                e.printStackTrace();
            }
        }
    }

    /**
     * will update the active controller
     */
    private void update() {

        activeController.update();
    }


    public void stopGame() {
        gameOn = false;
    }

    /**
     * as the function express it initializes the controllers and places them on a map
     * it uses the enum TypeOfControllers for the key
     */
    private void initializeControllers() {
        WelcomeViewController welcomeViewController = new WelcomeViewController(this, this.gui.frame);
        MainViewController mainViewController = new MainViewController(this, this.gui.frame);
        StructureViewController structureViewController = new StructureViewController(this);
        UnitViewController unitViewController = new UnitViewController(this);
//      TODO:CREATE TypeOfController.PauseView
        controllerMap.put(TypeOfControllers.WelcomeViewController, welcomeViewController);
        controllerMap.put(TypeOfControllers.MainViewController, mainViewController);
        controllerMap.put(TypeOfControllers.StructureViewController, structureViewController);
        controllerMap.put(TypeOfControllers.UnitViewController, unitViewController);

    }

    public void changeController(TypeOfControllers typeOfControllers) {


        this.gui.frame.getContentPane().removeAll(); // clears everthing that is currently in the frame
        this.gui.frame.getContentPane().validate();
        this.gui.frame.getContentPane().repaint();
        if (controllerMap.containsKey(typeOfControllers)) {
            Controller controller = controllerMap.get(typeOfControllers);
            activeController = controller;
            activeController.resumeController();
            activeController.update();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) { // all the input that is taken in gets handled here
        // we want to forward this to the currently active controller
        System.out.println("Key Pressed ==============================");
        this.activeController.handleKeyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Keu Released =================================");
        this.activeController.handleKeyReleased(e);
    }


}
