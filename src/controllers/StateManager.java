package controllers;


import controllers.types.MainViewController;
import controllers.types.StructureViewController;
import controllers.types.UnitViewController;
import controllers.types.WelcomeViewController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.HashMap;

/**
 * Created by jordi on 2/1/2017.
 */
public class StateManager extends Application{

    private HashMap<TypeOfControllers, Controller> controllerMap = new HashMap<>();       //used for controller change, so that access is O(1)
    private boolean gameOn;
    public final long FPS = 30;                            //frames per second
    final long LOOP_TIME = 1000l / FPS;                   //how long an update should take 1000 miliseconds/ FPS
    private Controller activeController;
    private Group root = new Group();

    /**
     * when class is initialized the controllers are too and the WelcomeViewController is activated
     */
    public StateManager() {
        initializeControllers();
        activeController = controllerMap.get(TypeOfControllers.WelcomeViewController);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(root, primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight());
        scene.setFill(null);
        Rectangle r = new Rectangle(0, 0, 250, 250);
        r.setFill(Color.BLUE);
        root.getChildren().add(r);

        primaryStage.setScene(scene);
        primaryStage.show();
        //primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            //public void handle(WindowEvent we) {
                //System.out.println("Stage is closing");
            //}
        //});
        //gameOn = true;
        //startGameLoop();
    }

    public Parent getRootNode(){ return root;}

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

        controllerMap.put(TypeOfControllers.MainViewController, mainViewController);
        controllerMap.put(TypeOfControllers.StructureViewController, structureViewController);
        controllerMap.put(TypeOfControllers.UnitViewController, unitViewController);
        controllerMap.put(TypeOfControllers.WelcomeViewController, welcomeViewController);
    }

    public void changeController(TypeOfControllers typeOfControllers) {

        if (controllerMap.containsKey(typeOfControllers)) {
            Controller controller = controllerMap.get(typeOfControllers);
            activeController = controller;
            controller.changeController();
        }
    }



}
