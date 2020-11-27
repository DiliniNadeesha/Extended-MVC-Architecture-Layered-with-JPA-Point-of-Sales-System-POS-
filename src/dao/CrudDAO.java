package dao;

import entity.SuperEntity;

import java.io.Serializable;
import java.util.List;

public interface CrudDAO <T extends SuperEntity,ID extends Serializable> extends SuperDAO {

    List<T> findAll() throws Exception;

    T find(ID key) throws Exception;

    //boolean void valata change venava, eyata hethuva vanne, hibernate valadi transaction eka
    //hariyata sidda nounoth exception ekak throw karanava, naththan hariyata transaction eka siddavenava

    void save(T entity) throws Exception;

    void update(T entity) throws Exception;

    void delete(ID key) throws Exception;
}
