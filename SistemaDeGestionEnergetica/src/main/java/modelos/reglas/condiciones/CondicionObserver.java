package modelos.reglas.condiciones;

import modelos.reglas.reglas.Regla;
import modelos.reglas.sensores.Sensor;

import java.math.BigDecimal;

public abstract class CondicionObserver {

    private Regla regla;

    private Sensor sensor;

    public CondicionObserver(Regla regla, Sensor sensor) {
        this.regla = regla;
        this.sensor = sensor;
    }

    public Regla getRegla() {
        return regla;
    }

    public void update(BigDecimal unValor ) { }
}
