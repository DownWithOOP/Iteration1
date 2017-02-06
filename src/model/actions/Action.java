package model.actions;

/**
 * Created by jordi on 2/1/2017.
 */
public interface Action {
     void execute();
     void applyModifier(ActionModifiers actionModifier);
     double getTurns();
     void setTurns(double turns);
}
