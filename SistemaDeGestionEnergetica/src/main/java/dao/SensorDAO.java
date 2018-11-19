package dao;

import modelos.reglas.sensores.Sensor;
import utilidades.DatabaseUtil;

public class SensorDAO {

    public Sensor getSensor(String nombre ){
        try {
            final String hql = "FROM Sensor where nombre = :nombre";
            Sensor sensor = DatabaseUtil.getSession().createQuery(hql,Sensor.class)
                    .setParameter("nombre",nombre).getSingleResult();

            return sensor;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
