package model;

import model.actions.Action;
import model.player.Player;

import java.util.HashMap;

/**
 * Created by cduica on 2/2/17.
 */
public class GameModel {

    private Player activePlayer;
    private HashMap<Integer, Action> actionMap;
    private HashMap<String, Player> players;

    public GameModel(){

    }

    public void update(){

    }

    public boolean passAction(String action){
        return false;
    }

    public boolean changeActivePlayer(String playerId){
        return false;
    }

    public boolean setupAttack(String playerId, String unitId){
        return false;
    }

    public boolean fillActionMap(){
        return false;
    }

    public Player getActivePlayer(){
        return activePlayer;
    }

}
