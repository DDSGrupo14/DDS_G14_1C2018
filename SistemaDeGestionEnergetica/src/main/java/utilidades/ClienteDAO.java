package utilidades;

import modelos.usuarios.Cliente;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDAO {

    final static EntityManager session = new Configuration().configure().buildSessionFactory().createEntityManager();

    public EntityManager getSession() {
        return session;
    }

    public Cliente obtenerClientePorUsername(String login_username){

        try {
            List<Cliente> clientes =  session.createQuery("from Cliente where loginUsuario=:username")
                    .setParameter("username",login_username).getResultList();

            if( clientes != null) return clientes.get(0); else return null;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        } finally {
            if( session.isOpen())
                session.close();
        }

    }

    public List<Cliente> listarClientes(){
        try {
            return session.createQuery("from Cliente").getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        } finally {
            if( session.isOpen())
                session.close();
        }
    }
}
