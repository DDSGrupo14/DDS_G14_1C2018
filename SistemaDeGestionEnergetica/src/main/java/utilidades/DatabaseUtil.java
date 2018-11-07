package utilidades;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class DatabaseUtil {

    static SessionFactory sf = new Configuration().configure().buildSessionFactory();
    static final EntityManager session = sf.createEntityManager();

    public static EntityManager getSession() {
        return session;
    }

    public static String persistir(Object o){
        try {
            session.getTransaction().begin();
            session.persist(o);
            session.getTransaction().commit();
            return "";
        } catch (Exception e){
            return "Error " + e.getMessage();
        } /*finally {
            if( session.isOpen())
                session.close();
        }*/
    }

}
