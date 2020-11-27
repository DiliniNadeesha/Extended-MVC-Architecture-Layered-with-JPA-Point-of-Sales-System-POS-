package dao;

import dao.custom.QueryDAO;
import entity.CustomEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class QueryDAOImplTest1 {

    public static void main(String[] args) throws Exception {

        QueryDAO queryDAO = DAOFactory.getInstance().getDAO(DAOType.QUERY);

        File jpaProp = new File("resources/application.properties");
        Properties properties = new Properties();
        properties.load(new FileInputStream(jpaProp));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DEP", properties);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        queryDAO.setEntityManager(em);

        CustomEntity c = queryDAO.getOrderDetail("OD001");
        System.out.println(c.getOrderId());
        System.out.println(c.getCustomerName());
        System.out.println(c.getOrderDate());

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
