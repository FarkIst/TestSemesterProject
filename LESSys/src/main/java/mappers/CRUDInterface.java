package mappers;

import java.util.Collection;

public interface CRUDInterface<E> {
    public Collection returnAllEntities();
    public E createEntity(E entity);
    public E readEntity(int id);
    public E editEntity(E entity);
    public void deleteEntity(int id);
}
