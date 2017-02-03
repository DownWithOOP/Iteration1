package controllers.keyboardInputHandler;

/**
 * Created by jordi on 2/2/2017.
 */
public enum TypeOfActions {
    /*controller actions*/changeView,
    /*player actions*/ cycleMode,cycleType, cycleTypeInstance, cycleCommand, selectUnit,
    /*Entity actions*/ cancelQueue, decomission, powerDown, powerUp,activateCommand,
    /*Structure actions*/ createUnit, healUnit,
    /*Unit actions*/ moveUnit,
    /*FighterUnit actions*/ joinArmy, abandonArmy,
    /*Fighter action*/ attack, defend,
    /*Directions*/ north,south,east,west,northEast,northWest,southEast,southWest
    }
