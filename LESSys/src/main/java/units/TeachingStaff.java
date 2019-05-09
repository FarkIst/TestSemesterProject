package units;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue( value="TS" )
public class TeachingStaff extends Staff{
    @OneToMany(
            mappedBy = "teacher",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Course> enrolledCourses = new ArrayList<Course>();

    private String qualifications;

    public TeachingStaff(){
        super();
    }

    public TeachingStaff(int id){
        super();
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void addEnrolledCourses(Course course) {
        getEnrolledCourses().add(course);
        course.setTeacher(this);
    }

    public void removeEnrolledCoursesCourse(Course course) {
        getEnrolledCourses().remove(course);
        course.setTeacher(null);
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public Calendar dateSinceLastTeachingPosition(){
        return null;
    }

    public Boolean hasTought20HoursLastSemester(){
        return true;
    }
}
