package units;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
public class School implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location", referencedColumnName = "id")
    private Location location;

    @OneToMany(
            mappedBy = "school",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Room> schoolRooms = new ArrayList<Room>();

    public void addRoom(Room room) {
        getSchoolRooms().add(room);
        room.setSchool(this);
    }

    public void removeRoom(Room room) {
        getSchoolRooms().remove(room);
        room.setSchool(null);
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Room> getSchoolRooms() {
        return schoolRooms;
    }

    public void setSchoolRooms(List<Room> schoolRooms) {
        this.schoolRooms = schoolRooms;
    }
}