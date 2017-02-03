package controllers.keyboardInputHandler;

import model.actions.AvailableActions;

import java.util.HashMap;

/**
 * Created by jordi on 2/2/2017.
 */
public class KeyBoardMapManager {
    private HashMap<String, HashMap<String, TypeOfActions>> playerInputHash;
    private HashMap<String, TypeOfActions> currentInputProcessor= new HashMap<>();
    private HashMap<String, TypeOfActions> defaultKeyMap= new HashMap<>();

    private String currentPlayerId;

    public KeyBoardMapManager(){
        playerInputHash=new HashMap<>();
//        populatePlayerInputHash();
    }


    /**
     * TODO:CHANGE this when using more than one key at a time, a queue for modifiers is needed
     * this is going to be called from the controller whenever the controller has acquired an input
     *
     * @param inputFromController
     */
    public TypeOfActions processInput(String inputFromController) {
        TypeOfActions typeOfAction= null;
        if (currentInputProcessor.containsKey(inputFromController)) {
            typeOfAction = currentInputProcessor.get(inputFromController);
        }
//        availableActions.executeAction(typeOfAction);
        return typeOfAction;
    }

    /**
     * this is going to be called from the GameManager after the turn is ended by the player
     *
     * @param playerId used to get the new keyboard style of the player
     */
    public void updatePlayerId(String playerId) {
        currentPlayerId=playerId;
        currentInputProcessor = playerInputHash.get(currentPlayerId);
    }

    /**
     * Used at the Welcome View to populate a player with their customized inputs
     * Something should call this method and iterate through an  xml file of the players' inputs and their controls
     * This class is used by Control to parse the inputs
     * This class is called by the GameManager whenever players are switched
     * TODO:a default iteration of the Dave's inputs, change the current implementation
     */
    public void populatePlayerInputHash(String playerId, HashMap<TypeOfActions,String> playerCustomizedControllers){
        HashMap<String,TypeOfActions> actionInput=new HashMap<>();

        for (TypeOfActions iterator: TypeOfActions.values()){
            if (playerCustomizedControllers.containsKey(iterator)){
                String key=playerCustomizedControllers.get(iterator);
                actionInput.put(key,iterator);
            }
        }
        playerInputHash.put(playerId, actionInput);
    }

    public void addPlayer(String playerId){
        playerInputHash.put(playerId,defaultKeyMap);
    }
//Todo: check how to do output then do this function
    private void fillDefaultKeyMap(){

    }
}
