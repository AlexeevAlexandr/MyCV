package commands;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class Commands {
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
}
