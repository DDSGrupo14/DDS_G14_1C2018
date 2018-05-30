package modelos.reglas.condiciones;

import modelos.reglas.reglas.Regla;

import java.math.BigDecimal;

public class CondicionTemperaturaBaja extends CondicionTemperatura {

    public CondicionTemperaturaBaja(Regla regla, Integer temperatura) {
        super(regla, temperatura);
    }

    @Override
    public void update( BigDecimal temperatura) {
        if( temperatura.compareTo( new BigDecimal( temperaturaPivote )) < 0 )
            this.getRegla().actuar();
    }
}
