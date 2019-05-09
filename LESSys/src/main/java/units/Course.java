package units;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
public class Course implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int id;

    private String name;

    private int teachingHours;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teacher_id")
    private TeachingStaff teacher;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToMany(mappedBy = "enrolledCourses")
    private
    Set<Student> enrolledStudents;

    @ManyToMany
    @JoinTable(
            name = "semesterCourses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "semester_id"))
    private Set<Semester> semesterCourses;

    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Payment> coursePayments = new ArrayList<Payment>();

    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Schedule> courseSchedules = new ArrayList<Schedule>();


    public Course(){}
    public Course(int id){
        this.setId(id);
    }

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

    public TeachingStaff getTeacher() {
        return teacher;
    }

    public void setTeacher(TeachingStaff teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Set<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public void addCoursePayment(Payment payment) {
        getCoursePayments().add(payment);
        payment.setCourse(this);
    }

    public void removeCoursePayment(Payment payment) {
        getCoursePayments().remove(payment);
        payment.setCourse(null);
    }

    public int returnEnrolledStudents(){
        return 0;
    }

    public Set<Semester> getSemesterCourses() {
        return semesterCourses;
    }

    public void setSemesterCourses(Set<Semester> semesterCourses) {
        this.semesterCourses = semesterCourses;
    }

    public Boolean isOver20TeachingHours() {
        if (this.teachingHours < 20) return false;
        return true;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }


    public List<Schedule> getCourseSchedules() {
        return courseSchedules;
    }

    public void setCourseSchedules(List<Schedule> courseSchedules) {
        this.courseSchedules = courseSchedules;
    }

    public void addSchedule(Schedule schedule) {
        getCourseSchedules().add(schedule);
        schedule.setCourse(this);
    }

    public void removeSchedule(Schedule schedule) {
        getCourseSchedules().remove(schedule);
        schedule.setCourse(null);
    }

    public int getTeachingHours() {
        return teachingHours;
    }

    public void setTeachingHours(int teachingHours) {
        this.teachingHours = teachingHours;
    }

    public List<Payment> getCoursePayments() {
        return coursePayments;
    }

    public void setCoursePayments(List<Payment> coursePayments) {
        this.coursePayments = coursePayments;
    }
}
