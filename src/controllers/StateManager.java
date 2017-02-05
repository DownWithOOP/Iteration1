package controllers;


import controllers.types.PauseViewController;
import controllers.types.gameControllers.MainViewController;
import controllers.types.gameControllers.StructureViewController;
import controllers.types.gameControllers.UnitViewController;
import controllers.types.WelcomeViewController;
import model.actions.ActionModifiers;
import view.View;
import view.GUI;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jordi on 2/1/2017.
 */
public class StateManager implements KeyListener {

    private HashMap<Integer,ActionModifiers> actionModifierMap=new HashMap<>();
    private int controlKey=0;
    private int screenHeight;
    private int screenWidth;

    private HashMap<TypeOfControllers, Controller> controllerMap = new HashMap<>();       //used for controller change, so that access is O(1)
    private boolean gameOn;
    public final long FPS = 30;                            //frames per second
    final long LOOP_TIME = 1000l / FPS;                   //how long an update should take 1000 miliseconds/ FPS
    private Controller activeController;
    public final GUI gui;
    private ArrayList<View> initialzedViews; // keeps track of all the views from the controllers, whenever we want to
    // switch to a new view, we get the disired view from here and call UpdateViewInGUI()


    /**
     * when class is initialized the controllers are too and the WelcomeViewController is activated
     */
    public StateManager() {
        gui = new GUI(); // this is where the GUI is created, runs in GUI.java which is in the views folder
        gui.frame.addKeyListener(this); // we add the keylistener here so stateManager handles all input and
        // then forwards it to the controller that is currently active, only 1 keylistener for the entire GUI
        fillActionModifiers();
        // at this point the GUI is initialized
        initializeControllers();
        // at this point we have all the controllers intitialized
        activeController = controllerMap.get(TypeOfControllers.WelcomeViewController);
        // when the game starts, we want to be at the WelcomeViewController
        // so we update the current view in the GUI to the welcomeView
        this.UpdateViewInGUI(this.controllerMap.get(TypeOfControllers.WelcomeViewController).returnViewToStateManager());
    }

    private void UpdateViewInGUI(View updateViewToThis){
        // we take the currenly active view, and the target view, and pass that to GUI.java to update
        this.gui.updateCurrentView(updateViewToThis);
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
        PauseViewController pauseViewController = new PauseViewController(this);
//      TODO:CREATE TypeOfController.PauseView

        controllerMap.put(TypeOfControllers.MainViewController, mainViewController);
        controllerMap.put(TypeOfControllers.StructureViewController, structureViewController);
        controllerMap.put(TypeOfControllers.UnitViewController, unitViewController);
        controllerMap.put(TypeOfControllers.WelcomeViewController, welcomeViewController);
        controllerMap.put(TypeOfControllers.PauseViewController, pauseViewController);
    }

    public void changeController(TypeOfControllers typeOfControllers) {

        if (controllerMap.containsKey(typeOfControllers)) {
            Controller controller = controllerMap.get(typeOfControllers);
            activeController = controller;
            controller.resume();
            // when the controllers are changed, we also want to update the GUI
            this.UpdateViewInGUI(controllerMap.get(typeOfControllers).returnViewToStateManager());
        }

    }

    private void fillActionModifiers(){
        actionModifierMap.put(KeyEvent.VK_UP,ActionModifiers.up);
        actionModifierMap.put(KeyEvent.VK_DOWN,ActionModifiers.down);
        actionModifierMap.put(KeyEvent.VK_LEFT,ActionModifiers.left);
        actionModifierMap.put(KeyEvent.VK_RIGHT,ActionModifiers.right);
        actionModifierMap.put(KeyEvent.VK_0,ActionModifiers.zero);
        actionModifierMap.put(KeyEvent.VK_1,ActionModifiers.one);
        actionModifierMap.put(KeyEvent.VK_2,ActionModifiers.two);
        actionModifierMap.put(KeyEvent.VK_3,ActionModifiers.three);
        actionModifierMap.put(KeyEvent.VK_4,ActionModifiers.four);
        actionModifierMap.put(KeyEvent.VK_5,ActionModifiers.five);
        actionModifierMap.put(KeyEvent.VK_6,ActionModifiers.six);
        actionModifierMap.put(KeyEvent.VK_7,ActionModifiers.seven);
        actionModifierMap.put(KeyEvent.VK_8,ActionModifiers.eight);
        actionModifierMap.put(KeyEvent.VK_9,ActionModifiers.nine);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("control: "+ controlKey);
    }

    @Override
    public void keyPressed(KeyEvent e) { // all the input that is taken in gets handled here
        // we want to forward this to the currently active controller
        //this.activeController.handleKeyPressed(e);



        System.out.println("INPUT detected in StateManager");
        System.out.println("active controller is: " +activeController.toString());
// these below are hardcoded, but it gives you an idea of how the views change

        if(activeController instanceof  WelcomeViewController){
            System.out.println("Welcome view");
            if(e.getKeyChar() == '1'){
                this.changeController(TypeOfControllers.MainViewController);
            }
            else if(e.getKeyChar() == '4'){
                System.exit(0);
            }
        }
        else if (activeController instanceof MainViewController){
            System.out.println("Main View");
            if(e.getKeyChar() == '1'){
                this.changeController(TypeOfControllers.PauseViewController);
            }
            else if(e.getKeyChar() == '4'){
                System.exit(0);
            }
        }
        else if(activeController instanceof PauseViewController){
            System.out.println("Pause View");
            if(e.getKeyChar() == '1'){
                this.changeController(TypeOfControllers.MainViewController);
            }
            else if(e.getKeyChar() == '4'){
                System.exit(0);
            }
        }

        /* Dunno what this does
        int keyPressed=e.getKeyCode();

        if (keyPressed!=KeyEvent.VK_CONTROL){
            handleInput(keyPressed);
        }
        else{
            controlKey=keyPressed;
        }
        */
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
        ActionModifiers actionModifier=ActionModifiers.none;
        if ((keyPressed==KeyEvent.VK_LEFT || keyPressed==KeyEvent.VK_RIGHT) && controlKey!=KeyEvent.VK_CONTROL ){
            handledInput= "" + "" + KeyEvent.VK_LEFT + "" + KeyEvent.VK_RIGHT;
        }
        if ((keyPressed==KeyEvent.VK_LEFT || keyPressed==KeyEvent.VK_RIGHT) && controlKey==KeyEvent.VK_CONTROL ){
            handledInput= KeyEvent.VK_CONTROL + "" + KeyEvent.VK_LEFT + "" + KeyEvent.VK_RIGHT;
        }
        if ((keyPressed==KeyEvent.VK_UP || keyPressed==KeyEvent.VK_DOWN) && controlKey!=KeyEvent.VK_CONTROL){
            handledInput="" + "" + KeyEvent.VK_DOWN + "" + KeyEvent.VK_UP;
        }
        if ((keyPressed==KeyEvent.VK_UP || keyPressed==KeyEvent.VK_DOWN) && controlKey==KeyEvent.VK_CONTROL){
            handledInput=KeyEvent.VK_CONTROL + "" + KeyEvent.VK_DOWN + "" + KeyEvent.VK_UP;
        }
        if (actionModifierMap.containsKey(keyPressed)){
            actionModifier=actionModifierMap.get(keyPressed);
        }

        activeController.receiveInput(handledInput, actionModifier);

    }
}
