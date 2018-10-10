package modelos.reglas.condiciones;

import modelos.reglas.reglas.Regla;
import modelos.reglas.sensores.Sensor;

import java.math.BigDecimal;

public class CondicionTemperaturaIgual extends CondicionTemperatura {

    public CondicionTemperaturaIgual(Regla regla, Sensor sensor, Integer temperatura) {
        super(regla, sensor, temperatura);
    }

    @Override
    public void update( BigDecimal temperatura) {
        if (temperatura.compareTo( new BigDecimal( this.temperaturaPivote )) == 0)
            this.getRegla().actuar();
    }
}
