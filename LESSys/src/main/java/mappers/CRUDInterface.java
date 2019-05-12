package mappers;

import java.util.List;

public interface CRUDInterface<E> {
    public List<E> returnAllEntities();
    public E createEntity(E entity);
    public E readEntity(int id);
    public E editEntity(E entity);
    public void deleteEntity(int id);
}
