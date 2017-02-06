package view.components;

import model.entity.Entity;
import model.entity.army.Army;
import model.entity.stats.Stats;
import model.entity.structure.Structure;
import model.entity.unit.EntityType;
import model.entity.unit.Unit;
import model.map.tile.ResourceType;
import model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Map;

public class StatusViewport extends JPanel {

    private JLabel[] statsLabels;
    private JLabel[] resourceLabels;
    private JLabel playerLabel;

    private Entity selectedEntity;
    private EntityType selectedEntityType;
    private Stats selectedEntityStats;

    public StatusViewport(GridBagLayout layout, Rectangle bounds, Player initialPlayer){
        super(layout);
        setOpaque(false);

        playerLabel = new JLabel(initialPlayer.getPlayerId());

        resourceLabels = new JLabel[initialPlayer.getResourceLevels().size()];

        selectedEntity = initialPlayer.getSelectedEntity();
        selectedEntityType = selectedEntity.getEntityID().getEntityType(0);

        switch (selectedEntityType){
            case ARMY:
                selectedEntityStats = ((Army) selectedEntity).getArmyStats();
                statsLabels = new JLabel[selectedEntityStats.getSize()];
                break;
            case UNIT:
                statsLabels = new JLabel[((Unit) selectedEntity).getUnitStats().getSize()];
                break;
            case STRUCTURE:
                statsLabels = new JLabel[((Structure) selectedEntity).getStructureStats().getSize()];
                break;
            case MELEE:
                statsLabels = new JLabel[((Unit) selectedEntity).getUnitStats().getSize()];
                break;
            case RANGED:
                statsLabels = new JLabel[((Unit) selectedEntity).getUnitStats().getSize()];
                break;
            case EXPLORER:
                statsLabels = new JLabel[((Unit) selectedEntity).getUnitStats().getSize()];
                break;
            case COLONIST:
                statsLabels = new JLabel[((Unit) selectedEntity).getUnitStats().getSize()];
                break;
            case BASE:
                statsLabels = new JLabel[((Structure) selectedEntity).getStructureStats().getSize()];
                break;
            case RALLYPOINT:
                statsLabels = new JLabel[1];
                break;
            default: //TODO ??
                statsLabels = new JLabel[1];
                break;
        }

        setPreferredSize(new Dimension((int)bounds.getWidth(),(int)bounds.getHeight()));
        setBorder(BorderFactory.createLineBorder(Color.black, 50));

        updatePlayerLabel(initialPlayer);
        updateResourceLabels(initialPlayer.getResourceLevels());
        updateStatLabels(selectedEntityStats);

    }

    private void updatePlayerLabel(Player updatedPlayer) {
        playerLabel.setText(updatedPlayer.getPlayerId());
    }

    private void updateResourceLabels(Map<ResourceType, Integer> resourceLevels) {
        if (resourceLevels.size() > resourceLabels.length){
            resourceLabels = new JLabel[resourceLevels.size()];
        }
        Iterator resourceLevelsItr = resourceLevels.entrySet().iterator();
        int labelIndex = 0;
        while (resourceLevelsItr.hasNext()){
            Map.Entry pair  = (Map.Entry)resourceLevelsItr.next();
            resourceLabels[labelIndex] = new JLabel(pair.getValue().toString());
            ++labelIndex;
        }
    }

    private void updateStatLabels(Stats updatedStats) {

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);//do I need this??? IDK
        System.out.println("PAINTING STATUS VIEWPORT");
    }
}