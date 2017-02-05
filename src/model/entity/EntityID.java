package model.entity;

import model.entity.unit.EntityType;

import java.util.UUID;

/**
 * Created by LesliesLaptop on 2/4/17.
 */
public class EntityID {
    private String id;
    private EntityType entityType;

    EntityID(EntityType entityType) {
        UUID tempID = UUID.randomUUID();
        id = tempID.toString();
        this.entityType = entityType;
    }

    public String getEntityType() {
        return entityType.toString();
    }

    public String getId() {
        return id;
    }
}
