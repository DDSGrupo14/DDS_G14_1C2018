package modelos.reglas.condiciones;

import modelos.reglas.reglas.Regla;
import modelos.reglas.sensores.Sensor;

import java.math.BigDecimal;

public class CondicionTemperaturaAlta extends CondicionTemperatura {

    public CondicionTemperaturaAlta(Regla regla, Sensor sensor, Integer temperatura) {
        super(regla, sensor, temperatura);
    }

    @Override
    public void update( BigDecimal temperatura) {
        if (temperatura.compareTo( new BigDecimal( temperaturaPivote )) > 0)
            this.getRegla().actuar();
    }
}
