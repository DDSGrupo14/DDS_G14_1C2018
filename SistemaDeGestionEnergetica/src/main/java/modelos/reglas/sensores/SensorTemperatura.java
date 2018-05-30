package modelos.reglas.sensores;

import modelos.reglas.condiciones.CondicionTemperatura;

public class SensorTemperatura extends Sensor {

    public void agregarCondicion(CondicionTemperatura condicion){

        this.getCondiciones().add( condicion );

    }

}
