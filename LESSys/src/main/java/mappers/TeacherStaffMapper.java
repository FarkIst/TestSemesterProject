package mappers;

import units.*;

import java.util.List;

public class TeacherStaffMapper extends GenericMapper<TeachingStaff> implements TeacherStaffInterface {

    public TeacherStaffMapper() {
        super(TeachingStaff.class);
    }

    public TeacherStaffMapper(String PU) {
        super(PU, TeachingStaff.class);
    }

    public boolean isExperienced() {
        return false;
    }

    public Course signUpCourse() {
        return null;
    }

    public List<Course> getEnrolledCourses() {
        return null;
    }

    public Course removeEntrolledCourses() {
        return null;
    }

    public Course addEnrolledCourses() {
        return null;
    }

    public List<Course> setEnrolledCourse() {
        return null;
    }

    public List<Course> getCourseHistory() {
        return null;
    }

    public List<User> getEnrolledStudents(Course course) {
        return null;
    }

    public TeachingStaff addToSchoolCouncil(int id) {
        TeachingStaff teacher = this.em.find(TeachingStaff.class, id);
        teacher.setIsCouncilMember(true);
        em.getTransaction().begin();
        em.merge(teacher);
        em.getTransaction().commit();
        return teacher;
    }
}
