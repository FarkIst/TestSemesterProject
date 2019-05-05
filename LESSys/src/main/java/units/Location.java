package units;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Location implements Serializable {
    @Id
    private int id;
}
