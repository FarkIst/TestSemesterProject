package units;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
public class Schedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar time_start;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar time_end;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "course_id")
    private Course course;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Calendar getTime_start() {
        return time_start;
    }

    public void setTime_start(Calendar time_start) {
        this.time_start = time_start;
    }

    public Calendar getTime_end() {
        return time_end;
    }

    public void setTime_end(Calendar time_end) {
        this.time_end = time_end;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
