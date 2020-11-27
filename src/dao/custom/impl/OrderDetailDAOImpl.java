package dao.custom.impl;

import dao.CrudDAOImpl;
import dao.custom.OrderDetailDAO;
import entity.Customer;
import entity.OrderDetail;
import entity.OrderDetailPK;
import org.hibernate.Session;

import java.util.List;

public class OrderDetailDAOImpl extends CrudDAOImpl<OrderDetail, OrderDetailPK> implements OrderDetailDAO {

//    private Session session;

//    @Override
    //Interface through injection (setSession method eka enne super DAO gen)
//    public void setSession(Session session) {
//        this.session = session;
//    }

//    @Override
//    public List<OrderDetail> findAll() throws Exception {
//        return session.createQuery("FROM entity.OrderDetail", OrderDetail.class).list();
//    }

//    @Override
//    public OrderDetail find(OrderDetailPK key) throws Exception {
//        return session.get(OrderDetail.class, key);
//    }

//    @Override
//    public void save(OrderDetail orderDetail) throws Exception {
//        session.save(orderDetail);
//    }

//    @Override
//    public void update(OrderDetail orderDetail) throws Exception {
//        session.update(orderDetail);
//    }

//    @Override
//    public void delete(OrderDetailPK orderDetailPK) throws Exception {
//        session.delete(session.load(OrderDetail.class, orderDetailPK));
//    }

}
