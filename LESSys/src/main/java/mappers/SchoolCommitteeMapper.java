package mappers;

import units.Staff;
import units.Subject;

import javax.persistence.EntityManager;
import java.util.List;

public class SchoolCommitteeMapper implements SchoolCommitteeInterface {
    private DataMapper dm;

    public SchoolCommitteeMapper(){
        this.dm = new DataMapper(DataVars.PU);
    }

    public SchoolCommitteeMapper(String PU){
        this.dm = new DataMapper(PU);
    }

    private EntityManager getEntityManager() {
        return dm.getEMF().createEntityManager();
    }

    public Subject suggestSubject(Staff staff, Subject subject) {
        return null;
    }

    public Subject voteSubject(Staff staff, Subject subject) {
        return null;
    }

    /**
     * Returns a list of current SchoolCommittee members
     * @return Staff
     */
    public List<Staff> returnAllEntities() {
        return null;
    }

    public Staff createEntity(Staff entity) {
        return null;
    }

    public Staff readEntity(int id) {
        return null;
    }

    public Staff editEntity(Staff entity) {
        return null;
    }

    public void deleteEntity(int id) {

    }
}
