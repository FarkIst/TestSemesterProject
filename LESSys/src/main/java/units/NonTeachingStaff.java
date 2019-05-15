package units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value="NTS" )
public class NonTeachingStaff extends Staff{
    private String field;

    public NonTeachingStaff() { super(); };
    public NonTeachingStaff(int id){
        super();
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
