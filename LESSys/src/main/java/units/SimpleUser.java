package units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value="SU" )
public class SimpleUser extends User{
    public SimpleUser(){
        super();
    }

    public SimpleUser(int id){
        super();
    }
}
