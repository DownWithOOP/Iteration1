package controllers;


import controllers.types.gameControllers.MainViewController;
import controllers.types.gameControllers.StructureViewController;
import controllers.types.gameControllers.UnitViewController;
import controllers.types.WelcomeViewController;

import java.util.HashMap;

/**
 * Created by jordi on 2/1/2017.
 */
public class StateManager {

    private HashMap<TypeOfControllers, Controller> controllerMap = new HashMap<>();       //used for controller change, so that access is O(1)
    private boolean gameOn;
    public final long FPS = 30;                            //frames per second
    final long LOOP_TIME = 1000l / FPS;                   //how long an update should take 1000 miliseconds/ FPS
    private Controller activeController;

    /**
     * when class is initialized the controllers are too and the WelcomeViewController is activated
     */
    public StateManager() {
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
        MainViewController mainViewController = new MainViewController(this);
        StructureViewController structureViewController = new StructureViewController(this);
        UnitViewController unitViewController = new UnitViewController(this);
        WelcomeViewController welcomeViewController = new WelcomeViewController(this);
//      TODO:CREATE TypeOfController.PauseView
        controllerMap.put(TypeOfControllers.MainViewController, mainViewController);
        controllerMap.put(TypeOfControllers.StructureViewController, structureViewController);
        controllerMap.put(TypeOfControllers.UnitViewController, unitViewController);
        controllerMap.put(TypeOfControllers.WelcomeViewController, welcomeViewController);
    }

    public void changeController(TypeOfControllers typeOfControllers) {

        if (controllerMap.containsKey(typeOfControllers)) {
            Controller controller = controllerMap.get(typeOfControllers);
            activeController = controller;
            controller.resumeController();
        }
    }



}
