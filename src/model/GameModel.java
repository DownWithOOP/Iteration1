package model;

import model.actions.Action;
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

    private final int MAP_HEIGHT = 3;
    private final int MAP_WIDTH = 3;

    public GameModel(){
        actionMap = new HashMap<>();
        players = new HashMap<>();
        players.put("player1", new Player("player1", new boolean[MAP_HEIGHT][MAP_WIDTH]));
        players.put("player2", new Player("player2", new boolean[MAP_HEIGHT][MAP_WIDTH]));
        map = new Map(MAP_HEIGHT, MAP_WIDTH);
    }

    public void update(){

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

    public Player getActivePlayer(){
        return activePlayer;
    }

    /**
     * Returns info from the model to be rendered.
     */
    public RenderObject getRenderObject(){
        return new RenderObject(map, activePlayer);
    }

}
