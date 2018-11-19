package modelos.dao;

import modelos.reglas.reglas.Regla;
import modelos.usuarios.Domicilio;
import utilidades.DatabaseUtil;

public class ReglaDAO {

    static String hql;

    public Regla getReglaParaApagar(Domicilio domicilio, String tipoRegla){
        try{

            hql= "FROM Regla where DTYPE = :tipoRegla and domicilio = :domicilio";
            Regla regla = DatabaseUtil.getSession().createQuery(hql,Regla.class)
                    .setParameter("domicilio",domicilio).setParameter("tipoRegla",tipoRegla)
                    .getSingleResult();

            return regla;
        } catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
            return null;
        }
    }
}
