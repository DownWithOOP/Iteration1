package model.map.tile;

/**
 * Created by cduica on 2/1/17.
 */
public class Resource {

    private ResourceType resourceType;
    private int level;

    public Resource(ResourceType resourceType){
        this.resourceType = resourceType;
        this.level = 100;
    }

    private ResourceType getResourceType(){
        return resourceType;
    }

    /**
     * Lowers resource level and returns amount of resource mined.
     */
    public int mine(){
        //TODO: perform operations with level
        return 0;
    }
}
