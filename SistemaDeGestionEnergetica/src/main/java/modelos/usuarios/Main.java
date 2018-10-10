package modelos.usuarios;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {

    static Cliente cliente;
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;

    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File

        try {
            Configuration configObj = new Configuration();
            configObj.configure();
            // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
            ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
            // Creating Hibernate SessionFactory Instance
            sessionFactoryObj = configObj.buildSessionFactory();
            return sessionFactoryObj;
        } catch (Throwable ex){
            System.err.println(ex);
            throw  new ExceptionInInitializerError(ex);
        }
    }

    public static void main(String[] args) {
        System.out.println(".......Hibernate Maven Example.......\n");
        try {
            sessionObj = buildSessionFactory().openSession();

            sessionObj.beginTransaction();
            cliente = new Cliente("nuevo","renuevo","4444444","12345", "admin", "admin");

            sessionObj.save(cliente);
            System.out.println("pase por aca\n");

            System.out.println("\n.......Records Saved Successfully To The Database.......\n");

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
}
