package dao;

import modelos.dispositivos.DispositivoEstandar;
import modelos.usuarios.Domicilio;
import utilidades.DatabaseUtil;

import java.util.List;

public class DispositivoEstandarDAO {
    static String hql;

    public List<DispositivoEstandar> getAllDispEstDomicilio(Domicilio domicilio){
        try{
            hql="FROM DispositivoEstandar where domicilio = :domicilio";
            List<DispositivoEstandar> lista = DatabaseUtil.getSession().createQuery(hql,DispositivoEstandar.class)
                    .setParameter("domicilio",domicilio).getResultList();
            return lista;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public DispositivoEstandar getDispositivoEstandar(String nombre){
        try{
            hql ="FROM DispositivoEstandar where nombre = :nombre";
            DispositivoEstandar dispEstandar = DatabaseUtil.getSession().createQuery(hql,DispositivoEstandar.class)
                    .setParameter("nombre",nombre).getSingleResult();

            return dispEstandar;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
