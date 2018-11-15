package utilidades;

import modelos.dispositivos.Categoria;
import java.util.List;

public class DomicilioDAO {

    public Categoria obtenerCategoriaPorNombre(String nombreCategoria){

        try {
            final String hql = "FROM Categoria where nombreCategoria = :nombre";
            List<Categoria> lista = DatabaseUtil.getSession().createQuery(hql,Categoria.class)
                    .setParameter("nombre",nombreCategoria).getResultList();

            if( lista != null) return lista.get(0); else return null;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
