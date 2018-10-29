package modelos.reglas.reglas;

import com.deliveredtechnologies.rulebook.model.RuleBook;
import modelos.reglas.actuadores.Actuador;
import modelos.reglas.condiciones.Condicion;
import modelos.reglas.sensores.Magnitud;
import modelos.reglas.sensores.Sensor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "regla")
public class Regla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regla_id", unique = true)
    private int regla_id;
    @OneToOne(fetch = FetchType.LAZY)
    //@MapsId
    @JoinColumn(name = "adap_id")
    private Actuador actuador;

    @OneToMany(
            mappedBy = "regla",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Condicion> condiciones = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    @Transient
    List<RuleBook> condiciones_a_cumplir = new ArrayList<>();

    public Regla(){}

    public int getRegla_id() {
        return regla_id;
    }

    public void setRegla_id(int regla_id) {
        this.regla_id = regla_id;
    }

    public Actuador getActuador() {
        return actuador;
    }

    public List<Condicion> getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(List<Condicion> condiciones) {

        if (condiciones == null)
            this.condiciones = condiciones;
        else
            condiciones.addAll(condiciones);
    }

    public void agregarCondicion(Condicion condicion){
        condiciones.add(condicion);
    }

    public void quitarCondicion( Condicion condicion) { condiciones.remove(condicion);}

    public void setActuador(Actuador actuador) {
        this.actuador = actuador;
    }

    public List<RuleBook> getCondiciones_a_cumplir() {
        return condiciones_a_cumplir;
    }

    public void setCondiciones_a_cumplir(List<RuleBook> condiciones_a_cumplir) {

        if (condiciones_a_cumplir == null)
            this.condiciones_a_cumplir = condiciones_a_cumplir;
        else
            this.condiciones_a_cumplir.addAll(condiciones_a_cumplir);
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public void actuar(){}

    public void update(Magnitud tipoMagnitud, int valor ){}

}
