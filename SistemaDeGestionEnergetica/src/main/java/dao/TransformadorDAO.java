package dao;

import modelos.enre.Transformador;
import utilidades.DatabaseUtil;

import java.util.List;

public class TransformadorDAO {

    static String hql;

    public List<Transformador> getAllTransformadores(){
        try{
            hql = "FROM Transformador ";
            return DatabaseUtil.getSession().createQuery(hql,Transformador.class)
                    .getResultList();
        } catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
            return null;
        }
    }

    public Transformador getTransformador(int id){
        try{
            hql = "from Transformador where transf_id = :id ";
            return DatabaseUtil.getSession().createQuery(hql,Transformador.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
            return null;
        }
    }
}
