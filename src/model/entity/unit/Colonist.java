package model.entity.unit;

import controllers.keyboardInputHandler.TypeOfActions;
import model.actions.Action;
import model.common.Location;
import model.entity.stats.StructureStats;
import model.entity.stats.UnitStats;
import model.entity.structure.Base;
import model.map.Map;
import model.player.Player;

import java.util.HashMap;

public class Colonist extends FighterUnit {

    protected HashMap<TypeOfActions, Action> colonistActions = new HashMap<>();


    public Colonist(Player player, Location location) {
        super(EntityType.COLONIST, new UnitStats(2, 1, 0, 3, 50, 1, 5,1),player, location);
        initializeColonist();
    }

    protected void initializeColonist() {
        setColonistActions();
        addAllActions(colonistActions);
    }

    private void setColonistActions(){
        /**
         *         colonistActions.put(TypeOfActions.powerUp,PowerUpAction(this));
         * */
    }

    public boolean buildStructure() {
        int fixedX = this.getLocation().getxCoord();
        int fixedY = this.getLocation().getyCoord();
        Base base = new Base(new StructureStats(10, 7, 15, 100, 5, 3, 8),
                             new Location(fixedX, fixedY),
                             getPlayer());
        if (getPlayer().addStructure(base)) {
            this.decommission(); //remove unit
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Player player = new Player("1", new Map());
        for (int i = 0; i < 12; i++) {
            Colonist colonist = new Colonist(player, new Location(0,0));
            player.addUnit(colonist);
            colonist.buildStructure();
        }
    }

}