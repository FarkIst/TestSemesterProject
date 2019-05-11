package units;

import helpers.TimeHelper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

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

    public Boolean hasRun3ConsecutiveYears() {
        List<Course> courses = this.getCourses();

        Calendar[][] lastSemesterDates = TimeHelper.getLast6Semesters();

        int semesterMatches = 0;

        for (Calendar[] c: lastSemesterDates){

            boolean semMatch = false;
            for (Course currCourse : courses) {
                Set<Semester> semList = currCourse.getSemesterCourses();
                        System.out.println("SemesterCourses AMT: "+ semList.size());
                int currMonth = c[0].get(Calendar.MONTH);
                for (Semester sem: semList){
                    int dayVariable = currMonth;
                    if (dayVariable == 0 || dayVariable == 8){
                        dayVariable ++;
                    } else {
                        dayVariable --;
                    }
                    Calendar tempCal = c[0];
                    tempCal.set(Calendar.MONTH, dayVariable);

                    if (TimeHelper.isTimeBetween(sem.getSemester_start(), sem.getSemester_end(), tempCal)) {
                        semMatch = true;
                    }
                }
            }
            if (semMatch) {
                semesterMatches++;
            }
        }
        System.out.println("Amount of matches: " +semesterMatches);
        if (semesterMatches > 5) return true;
        return false;
    }

    public void removeCourse(Course course) {
        getCourses().remove(course);
        course.setSubject(null);
    }

}
