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

    GraphicsInfo(){

    }
}