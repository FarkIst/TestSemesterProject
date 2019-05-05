package units;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name = "type" )

public class User implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int id;

    private String name;
    private Date birthDate;

    public User(){}

    public User(int id){
        this.id = id;
    }
}
