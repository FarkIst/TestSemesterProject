package units;

import helpers.TimeHelper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

@Entity
@Table
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
public class Semester implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int id;

    private SemesterTypes type;

    @Temporal(TemporalType.DATE)
    private Calendar semester_start;

    @Temporal(TemporalType.DATE)
    private Calendar semester_end;

    @ManyToMany(mappedBy = "semesterCourses")
    private
    Set<Course> semesterCourses;

    public Semester() {
        Calendar[] arr = TimeHelper.getCurrentSemester(TimeHelper.getCurrentDate());
        this.semester_start = arr[0];
        this.semester_end = arr[1];
    }

    public Semester(Calendar semester_start, Calendar semester_end){
        this.semester_start = semester_start;
        this.semester_end = semester_end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SemesterTypes getType() {
        return type;
    }

    public void setType(SemesterTypes type) {
        this.type = type;
    }

    public Calendar getSemester_start() {
        return semester_start;
    }

    public void setSemester_start(Calendar semester_start) {
        this.semester_start = semester_start;
    }

    public Calendar getSemester_end() {
        return semester_end;
    }

    public void setSemester_end(Calendar semester_end) {
        this.semester_end = semester_end;
    }

    public Set<Course> getSemesterCourses() {
        return semesterCourses;
    }

    public void setSemesterCourses(Set<Course> semesterCourses) {
        this.semesterCourses = semesterCourses;
    }

    public Calendar getTwoMonthsBeforeNextSemStart(){
        return null;
    }
}
