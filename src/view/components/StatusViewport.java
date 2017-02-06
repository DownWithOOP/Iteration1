package view.components;

import model.actions.*;
import model.actions.Action;
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

    private static final String armyImagePath = "res/images/army.png";
    private static final String baseImagePath = "res/images/base.png";
    private static final String colonistImagePath = "res/images/colonist.png";
    private static final String explorerImagePath = "res/images/explorer.png";
    private static final String meleeImagePath = "res/images/melee.png";
    private static final String rangedImagePath = "res/images/ranged.png";

    private JLabel[] statsLabels;
    private JLabel[] resourceLabels;
    private JLabel playerLabel;
    private JLabel actionLabel;
    private TilePanel entityPanel;

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

        playerLabel = new JLabel(initialPlayer.getPlayerId());
        //playerLabel. TODO change text size
        if (initialPlayer.getSelectedAction() != null){
            actionLabel = new JLabel("CurrentAction: " + initialPlayer.getSelectedAction().toString());
        }
        else{
            actionLabel = new JLabel("No Action Selected");
        }

        setPreferredSize(new Dimension((int)bounds.getWidth(),(int)bounds.getHeight()));
        setBorder(BorderFactory.createLineBorder(Color.black, 5));

        entityPanel = new TilePanel("", (int)bounds.getWidth(), (int)bounds.getHeight()/15);

        updatePlayerLabel(initialPlayer);
        updateActionLabel(initialPlayer.getSelectedAction());
        updateResourceLabels(initialPlayer.getResourceLevels());
        updateStatLabels(selectedEntityStats.getStatsMap());

        addPlayerLabel();
        addActionLabel();
        addResourceLabels();
        addStatLabels();
        constraints.fill = GridBagConstraints.VERTICAL;
        add(entityPanel, constraints);
    }

    private void addActionLabel() {
        add(actionLabel, constraints);
        constraints.gridy++;
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

    private void updateActionLabel(Action selectedAction) {
        if (selectedAction != null){
            actionLabel.setText("Current Action:" + selectedAction.toString());
        }
        else{
            actionLabel.setText("No Action Selected");
        }
        actionLabel.setForeground(Color.CYAN);
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
        updatePlayerLabel(updatedPlayer);
        updateActionLabel(updatedPlayer.getSelectedAction());
        updateResourceLabels(updatedPlayer.getResourceLevels());
        updateSelectedEntity(updatedPlayer);
        updateEntityPanel();
        updateStatLabels(selectedEntityStats.getStatsMap());
    }

    private void updateEntityPanel() {
        switch (selectedEntityType) {
            case ARMY:
                entityPanel.addEntityImage(armyImagePath);
                break;
            case UNIT:
                entityPanel.addEntityImage(meleeImagePath);
                break;
            case STRUCTURE:
                entityPanel.addEntityImage(baseImagePath);
                break;
            case MELEE:
                entityPanel.addEntityImage(meleeImagePath);
                break;
            case RANGED:
                entityPanel.addEntityImage(rangedImagePath);
                break;
            case EXPLORER:
                entityPanel.addEntityImage(explorerImagePath);
                break;
            case COLONIST:
                entityPanel.addEntityImage(colonistImagePath);
                break;
            case BASE:
                entityPanel.addEntityImage(baseImagePath);
                break;
            case RALLYPOINT: //TODO ????
                entityPanel.addEntityImage(null);
                break;
            default: //TODO ??
                entityPanel.addEntityImage(null);
                break;
        }
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
    }
}