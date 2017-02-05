package model.common;

import model.map.Map;
import model.player.Player;
import view.components.AreaViewport;
import view.components.StatusViewport;

/**
 * Information to be rendered by MainView
 */
public class RenderObject {
    Map map;
    Player player;

    public RenderObject(Map map, Player player){
        this.map = map;
        this.player = player;
    }

    public Map getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }
}