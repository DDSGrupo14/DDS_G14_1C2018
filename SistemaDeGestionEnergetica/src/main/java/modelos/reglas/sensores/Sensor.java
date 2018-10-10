package modelos.reglas.sensores;

import modelos.reglas.condiciones.CondicionObserver;
import modelos.usuarios.Domicilio;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dom_id")
    private Domicilio domicilio;

    @Transient
    private List<CondicionObserver> condiciones;

    public void agregarCondicion( CondicionObserver condicion){

        condiciones.add( condicion );
    }

    public List<CondicionObserver> getCondiciones() {
        return condiciones;
    }

    public Sensor(){}

    public int getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(int sensor_id) {
        this.sensor_id = sensor_id;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public void medirMagnitud(BigDecimal unValor ) {

        condiciones.forEach( condicion -> condicion.update(unValor) );
    }

}
