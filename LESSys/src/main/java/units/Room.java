package units;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String roomNumber;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "school_id")
    private School school;

    @OneToMany(
            mappedBy = "room",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Schedule> roomSchedules = new ArrayList<Schedule>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void addSchedule(Schedule schedule) {
        getRoomSchedules().add(schedule);
        schedule.setRoom(this);
    }

    public void removeSchedule(Schedule schedule) {
        getRoomSchedules().remove(schedule);
        schedule.setRoom(null);
    }

    public List<Schedule> getRoomSchedules() {
        return roomSchedules;
    }

    public void setRoomSchedules(List<Schedule> roomSchedules) {
        this.roomSchedules = roomSchedules;
    }
}
