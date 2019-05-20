package mappers;

import units.Location;

public class LocationMapper extends GenericMapper<Location>{
    public LocationMapper(){
        super(Location.class);
    }

    public LocationMapper(String PU){
        super(PU, Location.class);
    }
}
