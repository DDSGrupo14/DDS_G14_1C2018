package modelos.reglas.condiciones;

import modelos.reglas.reglas.Regla;
import modelos.reglas.sensores.Sensor;

import java.math.BigDecimal;

public class CondicionNoHayMovimiento extends CondicionObserver {

    public CondicionNoHayMovimiento(Regla regla, Sensor sensor) {
        super(regla, sensor);
    }

    @Override
    public void update(BigDecimal unValor) {

        /*
        Si el valor es 0, significa que no hay movimiento, cualquier otro valor lo sera.
         */

        if( unValor.equals( 0 ) )
            this.getRegla().actuar();
    }
}
