import controllers.StateManager;

public class Game {

    public static void main(String[] args) {
        StateManager sm= new StateManager();
        sm.launch(StateManager.class, args);
        sm.startGame();
    }
}
