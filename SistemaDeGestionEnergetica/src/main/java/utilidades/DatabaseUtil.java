package utilidades;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class DatabaseUtil {

    static SessionFactory sf = new Configuration().configure().buildSessionFactory();

    public static String persistir(Object o){
        final EntityManager session = sf.createEntityManager();

        try {
            session.getTransaction().begin();
            session.persist(o);
            session.getTransaction().commit();
            return "";
        } catch (Exception e){
            return "Error " + e.getMessage();
        } finally {
            if( session.isOpen())
                session.close();
        }
    }

}
