package dao.custom.impl;

import dao.CrudDAOImpl;
import dao.custom.OrderDAO;
import entity.Customer;
import entity.Order;
import org.hibernate.Session;

import java.util.List;

public class OrderDAOImpl extends CrudDAOImpl<Order, String> implements OrderDAO {

    public String getLastOrderId() throws Exception {
        List list = entityManager.createQuery("SELECT o.id FROM Order o ORDER BY o.id DESC ").setMaxResults(1).getResultList();
        return (list.size()>0)?(String)list.get(0):null;
    }
}
