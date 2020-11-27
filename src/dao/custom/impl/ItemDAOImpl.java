package dao.custom.impl;

import dao.CrudDAOImpl;
import dao.custom.ItemDAO;
import entity.Customer;
import entity.Item;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.List;

public class ItemDAOImpl extends CrudDAOImpl<Item, String> implements ItemDAO {

    public String getLastItemCode() throws Exception {
        //this code use jPQL and HQL
        try {
            List list = entityManager.createQuery("SELECT i.code FROM entity.Item i ORDER BY i.code DESC").setMaxResults(1).getResultList();
            return (list.size() > 0) ? (String) list.get(0) : null;
        }catch (NoResultException ex){
            return null;
        }
    }
}
