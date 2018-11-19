package dao;

import modelos.enre.Zona;
import modelos.usuarios.Domicilio;
import utilidades.DatabaseUtil;

import java.util.List;

public class ZonaDAO {

    public List<Zona> getAllZonas(){
        try {
            return DatabaseUtil.getSession().createQuery("from Zona ").getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void actualizarTransformadores(Zona zona){
        try{
            DomicilioDAO domicilioDAO = new DomicilioDAO();

            List<Domicilio> domicilios = domicilioDAO.getAllDomicilios();

            zona.getTransformadores().forEach(transformador -> transformador.getDirecciones().forEach(d -> {
                Domicilio domicilio = domicilios.stream().filter( dom -> dom.getDireccion().equals(d))
                        .findAny().orElse(null);
                if( (domicilio!= null )&&!transformador.equals(domicilio.getTransformador())){
                    domicilio.setTransformador(transformador);
                    DatabaseUtil.actualizar(domicilio);
                }
            }));
        }catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
}
