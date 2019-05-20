package mappers;

import units.SimpleUser;

public class SimpleUserMapper extends GenericMapper<SimpleUser> {

    public SimpleUserMapper() {
        super(SimpleUser.class);
    }

    public SimpleUserMapper(String PU) {
        super(PU, SimpleUser.class);
    }
}
