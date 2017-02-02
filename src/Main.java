import controllers.MainController;
import controllers.StateManager;

public class Main {

    public static void main(String[] args) {
        MainController a= new MainController(new StateManager());

    }
}
