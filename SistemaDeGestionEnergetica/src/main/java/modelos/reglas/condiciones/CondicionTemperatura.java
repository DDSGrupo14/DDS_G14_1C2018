package modelos.reglas.condiciones;

import modelos.reglas.reglas.Regla;
import modelos.reglas.sensores.Sensor;

public abstract class CondicionTemperatura extends CondicionObserver {

    public Integer temperaturaPivote;

    public CondicionTemperatura(Regla regla, Sensor sensor, Integer temperatura ) {

        super(regla, sensor);
        this.temperaturaPivote = temperatura;
    }

}
