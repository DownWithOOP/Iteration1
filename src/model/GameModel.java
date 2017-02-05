package model;

import model.actions.Action;
import model.actions.AvailableActions;
import model.common.RenderObject;
import model.map.Map;
import model.player.Player;

import java.util.HashMap;

/**
 * Created by cduica on 2/2/17.
 */
public class GameModel {

    private Player activePlayer;
    private HashMap<Integer, Action> actionMap;
    private HashMap<String, Player> players;
    private Map map;

    public GameModel(){
        actionMap = new HashMap<>();
        players = new HashMap<>();
        map = new Map();

        //TODO remove this so it doesn't ruin everything for everyone
        activePlayer = new Player("Dora");
    }

    public void update(){
        //graphicsInfo.update(activePlayer, activePlayer.getPlayerMap());
    }

    public boolean passAction(String action){
        if(actionMap.containsKey(action)){
            //do something wit dat action

            return true;
        }
        return false;
    }

    public boolean changeActivePlayer(String playerId){
        if(players.containsKey(playerId)){
            activePlayer = players.get(playerId);
            return true;
        }
        return false;
    }

    public boolean setupAttack(String playerId, String unitId){
        //we dont need attack lol
        return false;
    }

    public boolean fillActionMap(HashMap<Integer, Action> actionMap){
        this.actionMap = actionMap;
        return true;
    }

    /**
     * Returns info from the model to be rendered.
     */
    public RenderObject getRenderObject(){
        return new RenderObject(map, activePlayer);
    }

}
