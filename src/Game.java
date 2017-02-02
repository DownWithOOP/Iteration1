import controllers.MainController;
import controllers.StateManager;

public class Game {

    public static void main(String[] args) {
        StateManager sm= new StateManager();
        sm.startGame();
    }
}
