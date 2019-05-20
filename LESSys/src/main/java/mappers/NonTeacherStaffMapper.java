package mappers;

import units.NonTeachingStaff;
import units.Staff;
import units.Subject;

public class NonTeacherStaffMapper extends GenericMapper<NonTeachingStaff> implements StaffInterface {
    public NonTeacherStaffMapper() {
        super(NonTeachingStaff.class);
    }

    public NonTeacherStaffMapper(String PU) {
        super(PU, NonTeachingStaff.class);
    }

    public Staff addToSchoolCommittee(Staff staff) {
        return null;
    }

    public Subject suggestSubject(Staff staff, Subject subject) {
        return null;
    }

    public Subject voteSubject(Staff staff, Subject subject) {
        return null;
    }
}
