package units;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
public class Subject implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int id;

    private String name;

    @OneToMany(
            mappedBy = "subject",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Course> courses = new ArrayList<Course>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        getCourses().add(course);
        course.setSubject(this);
    }

    public Boolean hasRun3ConsecutiveYears() {return false;}

    public void removeCourse(Course course) {
        getCourses().remove(course);
        course.setSubject(null);
    }

}
