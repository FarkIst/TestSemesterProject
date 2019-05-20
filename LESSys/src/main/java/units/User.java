package units;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name = "type" )
public class User implements Serializable{
    @JsonProperty
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    protected int id;

    @JsonProperty
    protected String name;

    @JsonProperty
    @Temporal(TemporalType.DATE)
    private Calendar birthDate;

    public User(){}

    public User(int id){
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

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }
}
