package modelos.reglas.sensores;

import modelos.reglas.condiciones.Condicion;

import java.math.BigDecimal;
import java.util.List;

public abstract class Sensor{

    private List<Condicion> condiciones;

    public void agregarCondicion( Condicion condicion){

        condiciones.add( condicion );
    }

    public List<Condicion> getCondiciones() {
        return condiciones;
    }

    public void medirMagnitud(BigDecimal unValor ) {

        condiciones.stream().forEach( condicion -> condicion.update(unValor) );
    }
}
