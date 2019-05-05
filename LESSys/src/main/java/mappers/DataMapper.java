package mappers;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataMapper {
        public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("less");
}

