package mappers;

import units.TeachingStaff;

import javax.persistence.EntityManager;
import java.util.List;

public class TeacherMapper implements CRUDInterface<TeachingStaff> {
    private DataMapper dm;

    public TeacherMapper(){
        this.dm = new DataMapper(DataVars.PU);
    }

    public TeacherMapper(String PU){
        this.dm = new DataMapper(PU);
    }

    private EntityManager getEntityManager() {
        return dm.getEMF().createEntityManager();
    }

    public List<TeachingStaff> returnAllEntities() {
        return null;
    }

    public TeachingStaff createEntity(TeachingStaff entity) {
        return null;
    }

    public TeachingStaff readEntity(int id) {
        return null;
    }

    public TeachingStaff editEntity(TeachingStaff entity) {
        return null;
    }

    public void deleteEntity(int id) {

    }
}
