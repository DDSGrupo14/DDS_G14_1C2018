package utilidades;

import modelos.usuarios.Administrador;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.List;

public class AdministradorDAO {

    private final static EntityManager session = new Configuration().configure().buildSessionFactory().createEntityManager();

    public EntityManager getSession() {
        return session;
    }

    public Administrador obtenerAdministradorPorUsername( String login_username){
        try {
            List<Administrador> administradores =  session.createQuery("from Administrador where loginUsuario=:username")
                    .setParameter("username",login_username).getResultList();

            if( administradores != null) return administradores.get(0); else return null;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        } finally {
            if( session.isOpen())
                session.close();
        }
    }

    public List<Administrador> listarAdministradores(){
        try {
            return session.createQuery("from Administrador ").getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        } finally {
            if( session.isOpen())
                session.close();
        }
    }
}
