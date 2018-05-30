package modelos.reglas.condiciones;

import modelos.reglas.reglas.Regla;

import java.math.BigDecimal;

public abstract class Condicion extends ObserverSensor {

    private Regla regla;

    public Condicion(Regla regla) {
        this.regla = regla;
    }

    public Regla getRegla() {
        return regla;
    }

    public void update(BigDecimal unValor ) { }
}
