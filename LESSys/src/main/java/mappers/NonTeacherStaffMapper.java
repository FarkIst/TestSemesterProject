package mappers;

import units.NonTeachingStaff;
import units.Subject;

public class NonTeacherStaffMapper extends GenericMapper<NonTeachingStaff> implements StaffInterface<NonTeachingStaff> {
    public NonTeacherStaffMapper() {
        super(NonTeachingStaff.class);
    }

    public NonTeacherStaffMapper(String PU) {
        super(PU, NonTeachingStaff.class);
    }

    public NonTeachingStaff addToSchoolCouncil(int id) {
        NonTeachingStaff nonTeacherStaff = this.em.find(NonTeachingStaff.class, id);
        nonTeacherStaff.setIsCouncilMember(true);
        em.getTransaction().begin();
        em.merge(nonTeacherStaff);
        em.getTransaction().commit();
        return nonTeacherStaff;
    }
}
