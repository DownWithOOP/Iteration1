package model.entity.stats;

import model.map.Map;

import java.util.HashMap;

public class Stats {
    protected java.util.Map<StatsType, Integer> statsMap = new HashMap<>();
    //offensiveDamage;    // damage dealt when attacking
    //defensiveDamage;    // damage dealt when fending off an attack
    //armor;              // absorbs a fixed amount of damage
    //health;             // when reaches zero, unit is destroyed
    //upkeep;             // resources required to keep unit at full health
    //defaultUpkeep;
    //visionRadius;       // The amount of tiles on any side that an entity can see

    public Stats(int offensiveDamage, int defensiveDamage, int armor, int health, int upkeep, int visionRadius) {
        statsMap.put(StatsType.OFFENSIVE_DAMAGE, offensiveDamage);
        statsMap.put(StatsType.DEFENSIVE_DAMAGE, defensiveDamage);
        statsMap.put(StatsType.ARMOR, armor);
        statsMap.put(StatsType.HEALTH, health);
        statsMap.put(StatsType.UPKEEP, upkeep);
        statsMap.put(StatsType.DEFAULT_UPKEEP, upkeep);
        statsMap.put(StatsType.VISION_RADIUS, visionRadius);
    }

    public void setOffensiveDamage(int offensiveDamage) {
        statsMap.put(StatsType.OFFENSIVE_DAMAGE, offensiveDamage);
    }

    public int getOffensiveDamage() {
        return statsMap.get(StatsType.OFFENSIVE_DAMAGE);
    }

    public void setDefensiveDamage(int defensiveDamage) {
        statsMap.put(StatsType.DEFENSIVE_DAMAGE, defensiveDamage);
    }

    public int getDefensiveDamage() {
        return statsMap.get(StatsType.DEFENSIVE_DAMAGE);
    }

    public void setArmor(int armor) {
        statsMap.put(StatsType.ARMOR, armor);
    }

    public int getArmor() {
        return statsMap.get(StatsType.ARMOR);
    }

    public void setHealth(int health) {
        statsMap.put(StatsType.HEALTH, health);
    }

    public int getHealth() {
        return statsMap.get(StatsType.HEALTH);
    }

    public void setUpkeep(int upkeep) {
        statsMap.put(StatsType.UPKEEP, upkeep);
    }

    public int getUpkeep() {
        return statsMap.get(StatsType.UPKEEP);
    }

    public int getDefaultUpkeep() {
        return statsMap.get(StatsType.DEFAULT_UPKEEP);
    }

    public int getVisionRadius() {
        return statsMap.get(StatsType.VISION_RADIUS);
    }

    public void setVisionRadius(int visionRadius) {
        statsMap.put(StatsType.VISION_RADIUS, visionRadius);
    }

    public int getSize() {return statsMap.size();}

    public java.util.Map<StatsType, Integer> getStatsMap() {return statsMap;}

}

