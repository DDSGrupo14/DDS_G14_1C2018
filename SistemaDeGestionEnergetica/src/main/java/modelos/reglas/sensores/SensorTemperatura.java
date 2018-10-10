package modelos.reglas.sensores;

import modelos.reglas.condiciones.CondicionTemperatura;

import javax.persistence.Entity;

@Entity
public class SensorTemperatura extends Sensor {

    public void agregarCondicion(CondicionTemperatura condicion){

        this.getCondiciones().add( condicion );

    }

}
