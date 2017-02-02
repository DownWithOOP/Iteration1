package model.common;

import model.map.Map;
import model.player.Player;

/**
 * Hold information that {@link view.MainView} needs to render the
 * {@link view.AreaViewport} and {@link view.StatusViewport}
 */
public class GraphicsInfo {
    Map map;
    Player player;

    GraphicsInfo(){

    }
}