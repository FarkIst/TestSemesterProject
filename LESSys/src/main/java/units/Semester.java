package units;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
    private Date semester_start;

    @Temporal(TemporalType.DATE)
    private Date semester_end;

    @ManyToMany(mappedBy = "semesterCourses")
    private
    Set<Course> semesterCourses;

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

    public Date getSemester_start() {
        return semester_start;
    }

    public void setSemester_start(Date semester_start) {
        this.semester_start = semester_start;
    }

    public Date getSemester_end() {
        return semester_end;
    }

    public void setSemester_end(Date semester_end) {
        this.semester_end = semester_end;
    }

    public Set<Course> getSemesterCourses() {
        return semesterCourses;
    }

    public void setSemesterCourses(Set<Course> semesterCourses) {
        this.semesterCourses = semesterCourses;
    }

    public Date getTwoMonthsBeforeNextSemStart(){
        return null;
    }
}
