package dao;

import modelos.usuarios.Cliente;
import utilidades.DatabaseUtil;

import java.util.List;

public class ClienteDAO {

    public Cliente obtenerClientePorUsername(String login_username){

        try {
            final String hql = "FROM Cliente where login_usuario = :username";
            List<Cliente> lista = DatabaseUtil.getSession().createQuery(hql,Cliente.class)
                    .setParameter("username",login_username).getResultList();

            if( lista != null) return lista.get(0); else return null;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public List<Cliente> listarClientes(){
        try {
            return DatabaseUtil.getSession().createQuery("from Cliente").getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
