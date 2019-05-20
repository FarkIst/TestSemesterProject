package mappers;

        import units.Course;
        import units.Payment;
        import units.Student;

public interface StudentInterface {
    public Course registerCourse(Student student, Course course);
    public void leaveCourse(Student student, Course course);
    public Student makePayment(Student student, Course course, Payment payment);
}
