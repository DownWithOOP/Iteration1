package model.entity;

import model.actions.ActionModifiers;

/**
 * Created by jordi on 2/4/2017.
 */
public interface Fighter {
    void attack(ActionModifiers actionModifier);
    void defend(ActionModifiers actionModifier);
}
