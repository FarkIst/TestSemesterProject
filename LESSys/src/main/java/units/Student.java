package units;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue( value="S" )
public class Student extends User{
    @ManyToMany
    @JoinTable(
            name = "studentCourses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> enrolledCourses;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Payment> coursePayments = new ArrayList<Payment>();

    public Student(){};

    public Student( int id ){ super(id); };

    public Set<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(Set<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public void addEnrolledCourse(Course course) {
        this.enrolledCourses.add(course);
    }

    public void addCoursePayment(Payment payment) {
        getCoursePayments().add(payment);
        payment.setStudent(this);
    }

    public void removeCoursePayment(Payment payment) {
        getCoursePayments().remove(payment);
        payment.setStudent(null);
    }

    public List<Payment> getCoursePayments() {
        return coursePayments;
    }

    public void setCoursePayments(List<Payment> coursePayments) {
        this.coursePayments = coursePayments;
    }
}