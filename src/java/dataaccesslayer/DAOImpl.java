package dataaccesslayer;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author liyingguo
 */
public class DAOImpl<T> implements DAO<T> {    
    @Override
    public int insert(T t) {
        return 0;
    }

    @Override
    public int delete(Serializable id) {
        return 0;
    }

    @Override
    public int update(T t) {
        return 0;
    }

    @Override
    public T Retrieve(Serializable id) {
        return null;
    }

    @Override
    public List<T> RetrieveAll() {
        return null;
    }

}
