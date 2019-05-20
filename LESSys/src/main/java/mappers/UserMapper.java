package mappers;

import units.User;

public class UserMapper extends GenericMapper<User> {

    public UserMapper() {
        super(User.class);
    }

    public UserMapper(String PU) {
        super(PU, User.class);
    }
}
