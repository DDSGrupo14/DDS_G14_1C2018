package modelos.reglas.sensores;

import modelos.reglas.condiciones.CondicionObserver;

import java.math.BigDecimal;
import java.util.List;

public abstract class Sensor{

    private List<CondicionObserver> condiciones;

    public void agregarCondicion( CondicionObserver condicion){

        condiciones.add( condicion );
    }

    public List<CondicionObserver> getCondiciones() {
        return condiciones;
    }

    public void medirMagnitud(BigDecimal unValor ) {

        condiciones.forEach( condicion -> condicion.update(unValor) );
    }

}
