package mappers;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataMapper {
    private EntityManagerFactory emf;

    public DataMapper(String puN) {
        this.emf = Persistence.createEntityManagerFactory(puN);
    }

    public EntityManagerFactory getEMF(){
        return this.emf;
    }
}

