package units;

public abstract class UserFactory {
    public static User createUser(Role type) {
        User user = null;
        switch (type) {
            case S:
                user = new Student();
                break;
            case TS:
                user = new TeachingStaff();
                break;
            case NTS:
                user = new NonTeachingStaff();
                break;
        }
        return user;
    }
}
