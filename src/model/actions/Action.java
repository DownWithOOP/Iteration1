package model.actions;

/**
 * Created by jordi on 2/1/2017.
 */
public interface Action {
     void execute();
     void addToQueue(ActionModifiers actionModifier);
}
