package modelos.reglas.sensores;

import modelos.reglas.condiciones.CondicionObserver;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "sensor")
public class Sensor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id", unique = true)
    private int sensor_id;

    @Transient
    private List<CondicionObserver> condiciones;

    public void agregarCondicion( CondicionObserver condicion){

        condiciones.add( condicion );
    }

    public List<CondicionObserver> getCondiciones() {
        return condiciones;
    }

    public Sensor(){}


    public void medirMagnitud(BigDecimal unValor ) {

        condiciones.forEach( condicion -> condicion.update(unValor) );
    }

}
