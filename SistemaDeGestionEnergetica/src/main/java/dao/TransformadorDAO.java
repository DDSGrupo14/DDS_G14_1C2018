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

    public Transformador getTransformador(String codigo){
        try{
            hql = "from Transformador where codigo = :codigo ";
            return DatabaseUtil.getSession().createQuery(hql,Transformador.class)
                    .setParameter("codigo", codigo)
                    .getSingleResult();
        } catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
            return null;
        }
    }
}
