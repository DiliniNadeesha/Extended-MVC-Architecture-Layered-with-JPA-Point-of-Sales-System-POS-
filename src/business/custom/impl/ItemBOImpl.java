package business.custom.impl;

import business.custom.ItemBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.ItemDAO;
import db.JPAUtil;
import entity.Item;
import org.hibernate.Transaction;
import util.ItemTM;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {

    // Dependency Declaration
    private ItemDAO itemDAO;

    public ItemBOImpl() {
        // Constructor Injection
        this.itemDAO = DAOFactory.getInstance().getDAO(DAOType.ITEM);
    }

    public String getNewItemCode() throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        itemDAO.setEntityManager(entityManager);
        String lastItemCode = null;
        Transaction tx = null;
        try {
            entityManager.getTransaction().begin();
            lastItemCode = itemDAO.getLastItemCode();
            entityManager.getTransaction().commit();
        } catch (Throwable t) {
            entityManager.getTransaction().rollback();
            throw t;
        } finally {
            entityManager.close();
        }

        if (lastItemCode == null) {
            return "I001";
        } else {
            int maxId = Integer.parseInt(lastItemCode.replace("I", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "I00" + maxId;
            } else if (maxId < 100) {
                id = "I0" + maxId;
            } else {
                id = "I" + maxId;
            }
            return id;
        }
    }


    public List<ItemTM> getAllItems() throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        itemDAO.setEntityManager(entityManager);
        List<Item> allItems = null;
        Transaction tx = null;
        try {
            entityManager.getTransaction().begin();
            allItems = itemDAO.findAll();
            entityManager.getTransaction().commit();
        } catch (Throwable t) {
            entityManager.getTransaction().rollback();
            throw t;
        } finally {
            entityManager.close();
        }
        List<ItemTM> items = new ArrayList<>();
        for (Item item : allItems) {
            items.add(new ItemTM(item.getCode(), item.getDescription(), item.getQtyOnHand(), item.getUnitPrice().doubleValue()));
        }
        return items;
    }

    @Override
    public void saveItem(String code, String description, int qtyOnHand, BigDecimal unitPrice) throws Exception {

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        itemDAO.setEntityManager(entityManager);
        Transaction tx = null;
        try {
            entityManager.getTransaction().begin();
            itemDAO.save(new Item(code, description, unitPrice, qtyOnHand));
            entityManager.getTransaction().commit();
        } catch (Throwable t) {
            entityManager.getTransaction().rollback();
            throw t;
        } finally {
            entityManager.close();
        }
    }

    public void deleteItem(String itemCode) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        itemDAO.setEntityManager(entityManager);
        Transaction tx = null;
        try {
            entityManager.getTransaction().begin();
            itemDAO.delete(itemCode);
            entityManager.getTransaction().commit();
        } catch (Throwable t) {
            entityManager.getTransaction().rollback();
            throw t;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void updateItem(String description, int qtyOnHand, BigDecimal unitPrice, String itemCode) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        itemDAO.setEntityManager(entityManager);
        Transaction tx = null;
        try {
            entityManager.getTransaction().begin();
            itemDAO.update(new Item(itemCode, description, unitPrice, qtyOnHand));
            entityManager.getTransaction().commit();
        } catch (Throwable t) {
            entityManager.getTransaction().rollback();
            throw t;
        } finally {
            entityManager.close();
        }
    }
}
