package daos;

import java.util.List;

public interface Dao<T, PK> {
    List<T> findAll();
    T findById(PK pk);
    void insert(T Item);
    Boolean update(T Item);
    Boolean delete(PK pk);
    
}
