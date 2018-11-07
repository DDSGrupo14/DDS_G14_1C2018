package utilidades;

import modelos.usuarios.Administrador;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.List;

public class AdministradorDAO {

    public Administrador obtenerAdministradorPorUsername( String login_username){
        try {
            final String hql = "FROM Administrador where login_usuario = :username";
            List<Administrador> lista = DatabaseUtil.getSession().createQuery(hql,Administrador.class)
                    .setParameter("username",login_username).getResultList();

            if( lista != null) return lista.get(0); else return null;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Administrador> listarAdministradores(){
        try {
            return DatabaseUtil.getSession().createQuery("from Administrador ").getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
