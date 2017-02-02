package controllers;


import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by jordi on 2/1/2017.
 */
public class StateManager {
    final Controller[] controllerArray = new Controller[4];

    private boolean gameOn;
    public final long FPS = 1;                            //frames per second
    final long LOOP_TIME = 1000l / FPS;                   //how long an update should take 1000 miliseconds/ FPS

    public StateManager() {
        MainController a = new MainController(this);
        controllerArray[0] = a;
    }

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

    //Ensures the amount of frames per second of the game
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

    private void update() {
        controllerArray[0].update();
    }

    public void stopGame() {
        gameOn = false;
    }

}
