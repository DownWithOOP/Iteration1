package controllers.kyeboardInputHandler;

import model.actions.AvailableActions;
import model.player.Player;

import java.util.HashMap;

/**
 * Created by jordi on 2/2/2017.
 */
public class KeyBoardMapManager {
    static private HashMap<String, HashMap<Integer, TypeOfActions>> playerInputHash;
    private String currentPlayerId;
    private HashMap<Integer, TypeOfActions> currentInputProcessor= new HashMap<>();
    private AvailableActions availableActions = new AvailableActions();

    public KeyBoardMapManager(){
        playerInputHash=new HashMap<>();
        populatePlayerInputHash();
    }



    /**
     * TODO:CHANGE this when using more than one key at a time, a queue for modifiers is needed
     * this is going to be called from the controller whenever the controller has acquired an input
     *
     * @param inputFromController
     */
    public void processInput(Integer inputFromController) {
        TypeOfActions typeOfAction;
        if (!currentInputProcessor.containsKey(inputFromController)) {
            return;
        }
        typeOfAction = currentInputProcessor.get(inputFromController);
        availableActions.executeAction(typeOfAction);
    }

    /**
     * this is going to be called from the GameManager after the turn is ended by the player
     *
     * @param playerId used to get the new keyboard style of the player
     */
    public void updatePlayerId(String playerId) {
        currentInputProcessor = playerInputHash.get(playerId);
    }

    /**
     * Used at the Welcome View to populate all the players with their customized inputs
     * The GameManager should call this method and iterate through an  xml file of the players and their controls
     * TODO:a default iteration of the Dave inputs, change the current implementation
     */
    private void populatePlayerInputHash(){
        HashMap<Integer,TypeOfActions> actionInput=new HashMap<>();
        actionInput.put(1,TypeOfActions.changeView);
        playerInputHash.put("Player1", actionInput);
    }
}
