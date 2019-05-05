package units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value="NTS" )
public class NonTeachingStaff extends Staff{
    private String field;
}
