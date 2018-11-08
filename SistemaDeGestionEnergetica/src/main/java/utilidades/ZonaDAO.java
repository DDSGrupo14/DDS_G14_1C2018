package utilidades;

import modelos.enre.Zona;

import java.util.List;

public class ZonaDAO {

    public List<Zona> obtenerZonas(){
        try {
            return DatabaseUtil.getSession().createQuery("from Zona ").getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
