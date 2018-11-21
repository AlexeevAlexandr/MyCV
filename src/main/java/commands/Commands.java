package commands;

import dataBaseConnect.DataBaseConnect;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Commands  {
    private Transaction transaction = null;

    public List list() {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM DataBaseConnect").list();
        } catch (HibernateException e) {
            e.getMessage();
        }
        return null;
    }

    public List getPassword() {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT password FROM Password WHERE id=1").list();
        } catch (HibernateException e) {
            e.getMessage();
        }
        return null;
    }

    public void add(String firstName, String lastName, String email, String date) throws Exception {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession())
        {
            transaction = session.beginTransaction();
            DataBaseConnect dataBaseConnect = new DataBaseConnect(firstName, lastName, email, date);
            session.save(dataBaseConnect);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw new Exception();
            }
            e.getMessage();
        }
    }
}
