package model.map.tile.areaeffect;

/**
 * Created by cduica on 2/2/17.
 */
public class AreaEffectFactory {

    public AreaEffect createAreaEffect(String type){

        switch(type) {

            case "HEAL_DAMAGE" :
                return new HealDamage();
            case "TAKE_DAMAGE" :
                return new TakeDamage();
            case "INSTANT_DEATH " :
                return new InstantDeath();
            default : return null;

        }

    }

}
