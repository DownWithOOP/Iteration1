package view.components;

import model.entity.Entity;
import model.entity.army.Army;
import model.entity.stats.Stats;
import model.entity.stats.StatsType;
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

    private GridBagConstraints constraints;

    public StatusViewport(GridBagLayout layout, Rectangle bounds, Player initialPlayer){
        super(layout);
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        setOpaque(false);

        updateSelectedEntity(initialPlayer);

        //Get inital data
        playerLabel = new JLabel(initialPlayer.getPlayerId());


        setPreferredSize(new Dimension((int)bounds.getWidth(),(int)bounds.getHeight()));
        setBorder(BorderFactory.createLineBorder(Color.black, 50));


        updatePlayerLabel(initialPlayer);
        updateResourceLabels(initialPlayer.getResourceLevels());
        updateStatLabels(selectedEntityStats.getStatsMap());

        addPlayerLabel();
        addResourceLabels();
        addStatLabels();
    }

    private void addStatLabels() {
        if (statsLabels.length > 0) {
            for (int labelIndex = 0; labelIndex < statsLabels.length; ++labelIndex) {
                add(statsLabels[labelIndex], constraints);
                this.constraints.gridy++;
            }
        }
    }

    private void addResourceLabels() {
        if (resourceLabels.length > 0) {
            for (int labelIndex = 0; labelIndex < resourceLabels.length; ++labelIndex) {
                System.out.println(constraints.gridy);
                add(resourceLabels[labelIndex], constraints);
                this.constraints.gridy++;
            }
        }
    }

    private void addPlayerLabel() {
        add(playerLabel, constraints);
        this.constraints.gridy++;
    }

    private void updatePlayerLabel(Player updatedPlayer) {
        playerLabel.setText("Current Player: " + updatedPlayer.getPlayerId());
        playerLabel.setForeground(Color.CYAN);
    }

    private void updateResourceLabels(Map<ResourceType, Integer> resourceLevels) {
        resourceLabels = new JLabel[resourceLevels.size()];
        Iterator resourceLevelsItr = resourceLevels.entrySet().iterator();
        int labelIndex = 0;
        while (resourceLevelsItr.hasNext()){
            Map.Entry pair  = (Map.Entry)resourceLevelsItr.next();
            resourceLabels[labelIndex] = new JLabel(pair.getKey().toString() + ": " + pair.getValue().toString());
            resourceLabels[labelIndex].setForeground(Color.CYAN);
            ++labelIndex;
        }
    }

    private void updateStatLabels(Map<StatsType, Integer> stats) {
        statsLabels = new JLabel[stats.size()];
        Iterator statsItr = stats.entrySet().iterator();
        int labelIndex = 0;
        while (statsItr.hasNext()){
            Map.Entry pair  = (Map.Entry)statsItr.next();
            statsLabels[labelIndex] = new JLabel(pair.getKey().toString() + ": " + pair.getValue().toString());
            statsLabels[labelIndex].setForeground(Color.CYAN);
            playerLabel.setForeground(Color.CYAN);
            ++labelIndex;
        }
    }

    public void update(Player updatedPlayer){
        System.out.println("STATUS UPDATE");
        updatePlayerLabel(updatedPlayer);
        updateResourceLabels(updatedPlayer.getResourceLevels());
        updateSelectedEntity(updatedPlayer);
        updateStatLabels(selectedEntityStats.getStatsMap());
    }

    private void updateSelectedEntity(Player updatedPlayer) {
        selectedEntity = updatedPlayer.getSelectedEntity();
        selectedEntityType = selectedEntity.getEntityID().getEntityType(0);

        switch (selectedEntityType){
            case ARMY:
                selectedEntityStats = ((Army) selectedEntity).getArmyStats();
                break;
            case UNIT:
                selectedEntityStats = ((Unit) selectedEntity).getUnitStats();
                break;
            case STRUCTURE:
                selectedEntityStats = ((Structure) selectedEntity).getStructureStats();
                break;
            case MELEE:
                selectedEntityStats = ((Unit) selectedEntity).getUnitStats();
                break;
            case RANGED:
                selectedEntityStats = ((Unit) selectedEntity).getUnitStats();
                break;
            case EXPLORER:
                selectedEntityStats = ((Unit) selectedEntity).getUnitStats();
                break;
            case COLONIST:
                selectedEntityStats = ((Unit) selectedEntity).getUnitStats();
                break;
            case BASE:
                selectedEntityStats = ((Structure) selectedEntity).getStructureStats();
                break;
            case RALLYPOINT: //TODO ????
                selectedEntityStats = ((Structure) selectedEntity).getStructureStats();
                break;
            default: //TODO ??
                selectedEntityStats = ((Structure) selectedEntity).getStructureStats();
                break;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);//do I need this??? IDK
        System.out.println("PAINTING STATUS VIEWPORT");
    }
}