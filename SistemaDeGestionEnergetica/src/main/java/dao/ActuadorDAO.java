package dao;

import modelos.reglas.actuadores.Actuador;
import utilidades.DatabaseUtil;

public class ActuadorDAO {

    public Actuador getActuador(String nombre){
        try {
            final String hql = "FROM Actuador where nombre = :nombre";
            Actuador actuador = DatabaseUtil.getSession().createQuery(hql,Actuador.class)
                    .setParameter("nombre",nombre).getSingleResult();

            return actuador;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
