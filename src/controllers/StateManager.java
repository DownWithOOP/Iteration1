package controllers;


import controllers.types.gameControllers.MainViewController;
import controllers.types.gameControllers.StructureViewController;
import controllers.types.gameControllers.UnitViewController;
import controllers.types.WelcomeViewController;
import view.View;
import view.types.MainView;
import view.types.WelcomeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.Key;
import java.util.HashMap;

/**
 * Created by jordi on 2/1/2017.
 */
public class StateManager implements KeyListener {

    private int controlKey=0;
    private int screenHeight;
    private int screenWidth;

    private HashMap<TypeOfControllers, Controller> controllerMap = new HashMap<>();       //used for controller change, so that access is O(1)
    private boolean gameOn;
    public final long FPS = 30;                            //frames per second
    final long LOOP_TIME = 1000l / FPS;                   //how long an update should take 1000 miliseconds/ FPS
    private Controller activeController;
    private final JFrame gameFrame = new JFrame("Space Cats"); //frame to which all Views will be added

    //collection of all game view objects that gameFrame must contain. Each view should be added to corresponding controller
    //TODO views should be final; think of better way to initialize
    private View welcomeView;
    private View mainView;
    //private final UnitView unitView;
    //private final StructureView structureView;
    //private final PauseView pauseView;

    /**
     * when class is initialized the controllers are too and the WelcomeViewController is activated
     */
    public StateManager() { // this is where the GUI is created
        initGui();
        // at this point the GUI is initialized
        initializeControllers();
        // at this point we have all the controllers intitialized
        activeController = controllerMap.get(TypeOfControllers.WelcomeViewController);
        // when the game starts, we want to be at the WelcomeViewController
    }

    private void initGui() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenHeight = screenSize.height;
        screenWidth = screenSize.width;
        gameFrame.setSize(screenWidth,screenHeight);
        gameFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        gameFrame.addKeyListener(this); // bind keylistener to the gui that is running

        welcomeView = new WelcomeView();
        mainView = new MainView();
        //unitView = new UnitView();
        //structureView = new StructureView();
        //pauseView = new PauseView();

        welcomeView.setVisible(true);
        welcomeView.setFocusable(true);
        welcomeView.addKeyListener(this);
        gameFrame.add(welcomeView);

        mainView.setVisible(false);
        mainView.setFocusable(true);
        mainView.addKeyListener(this);
        gameFrame.add(mainView);

        gameFrame.setVisible(true);
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


    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("control: "+ controlKey);
    }

    @Override
    public void keyPressed(KeyEvent e) { // all the input that is taken in gets handled here
        // we want to forward this to the currently active controller
//        this.activeController.handleKeyPressed(e);
        int keyPressed=e.getKeyCode();

        if (keyPressed!=KeyEvent.VK_CONTROL){
            handleInput(keyPressed);
        }
        else{
            controlKey=keyPressed;
        }

        System.out.println("control: "+ controlKey);
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        this.activeController.handleKeyReleased(e);
        if (e.getKeyCode()== KeyEvent.VK_CONTROL){
            controlKey=0;
        }
    }

    private void handleInput(int keyPressed){
        String handledInput=keyPressed+"";
        if ((keyPressed==KeyEvent.VK_LEFT || keyPressed==KeyEvent.VK_RIGHT) && controlKey!=KeyEvent.VK_CONTROL ){
            handledInput= "" + "" + KeyEvent.VK_LEFT + "" + KeyEvent.VK_RIGHT;
        }
        if ((keyPressed==KeyEvent.VK_LEFT || keyPressed==KeyEvent.VK_RIGHT) && controlKey==KeyEvent.VK_CONTROL ){
            handledInput= KeyEvent.VK_CONTROL + "" + KeyEvent.VK_LEFT + "" + KeyEvent.VK_RIGHT;
        }
        if ((keyPressed==KeyEvent.VK_UP || keyPressed==KeyEvent.VK_DOWN) && controlKey!=KeyEvent.VK_CONTROL){
            handledInput="" + "" + KeyEvent.VK_UP + "" + KeyEvent.VK_UP;
        }
        if ((keyPressed==KeyEvent.VK_UP || keyPressed==KeyEvent.VK_DOWN) && controlKey==KeyEvent.VK_CONTROL){
            handledInput=KeyEvent.VK_CONTROL + "" + KeyEvent.VK_UP + "" + KeyEvent.VK_UP;
        }

        activeController.receiveInput(handledInput);

    }
}
