package dao.custom.impl;

import dao.CrudDAOImpl;
import dao.custom.CustomerDAO;
import entity.Customer;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.List;

//CrudDAOImpl<Customer, String> = Parameter Type
public class CustomerDAOImpl extends CrudDAOImpl<Customer, String> implements CustomerDAO {

//    private Session session;
//
//    @Override
    //Interface through injection (setSession method eka enne super DAO gen)
//    public void setSession(Session session) {
//        this.session = session;
//    }

    @Override
    public String getLastCustomerId() throws Exception {
        try {
            return (String) entityManager.createNativeQuery("SELECT id FROM customer ORDER BY id DESC LIMIT 1").getSingleResult();
        }catch (NoResultException ex){
            return null;
        }
    }

//    @Override
//    public List<Customer> findAll() throws Exception {
//        return session.createQuery("FROM entity.Customer", Customer.class).list();
//    }
//
//    @Override
//    public Customer find(String key) throws Exception {
//        //get or find 2ma use kala haka
//        //return session.find(Customer.class, key);
//        return session.get(Customer.class, key);
//    }
//
//    @Override
//    public void save(Customer customer) throws Exception {
//        session.save(customer);
//    }
//
//    @Override
//    public void update(Customer customer) throws Exception {
//         session.update(customer);
//    }
//
//    @Override
//    public void delete(String key) throws Exception {
//        session.delete(session.load(Customer.class, key));
//    }
}
