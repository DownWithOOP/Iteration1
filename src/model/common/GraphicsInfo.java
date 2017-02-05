package model.common;

import model.map.Map;
import model.player.Player;
import view.components.AreaViewport;
import view.components.StatusViewport;

/**
 * Hold information that {@link view.types.MainView} needs to render the
 * {@link AreaViewport} and {@link StatusViewport}
 */
public class GraphicsInfo {
    Map map;
    Player player;

    public GraphicsInfo(Map activeMap, Player activePlayer){
        this.player = activePlayer;
        this.map = activeMap;
    }

    public void update(Map activeMap, Player activePlayer){
        this.player = activePlayer;
        this.map = activeMap;
    }
}