package modelos.reglas.condiciones;

import modelos.reglas.reglas.Regla;

import java.math.BigDecimal;

public class CondicionTemperaturaAlta extends CondicionTemperatura {

    public CondicionTemperaturaAlta(Regla regla, Integer temperatura) {
        super(regla, temperatura);
    }

    @Override
    public void update( BigDecimal temperatura) {
        if (temperatura.compareTo( new BigDecimal( temperaturaPivote )) > 0)
            this.getRegla().actuar();
    }
}
