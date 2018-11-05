package modelos.reglas.condiciones;

import modelos.reglas.reglas.Regla;
import modelos.reglas.sensores.Magnitud;
import modelos.reglas.sensores.Sensor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "condicion")
public class Condicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "condicion_id", unique = true)
    private int condicion_id;

    @Column
    private int operador;
    @Column
    private Integer limite;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regla_id")
    private Regla regla;

    @Transient
    private Boolean condicionCumplida = false;

    public Condicion(int operador, Integer limite) {
        this.operador = operador;
        this.limite = limite;
    }

    public Condicion(){}

    public int getCondicion_id() {
        return condicion_id;
    }

    public void setCondicion_id(int condicion_id) {
        this.condicion_id = condicion_id;    }

    public int getOperador() {
        return operador;
    }

    public void setOperador(int operador) {
        this.operador = operador;
    }

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }

    public Regla getRegla() {
        return regla;
    }

    public void setRegla(Regla regla) {
        this.regla = regla;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Boolean getCondicionCumplida() {
        return condicionCumplida;
    }

    public void setCondicionCumplida(Boolean condicionCumplida) {
        this.condicionCumplida = condicionCumplida;
    }

    public Condicion getClaseConcreta(){
        return null;
    }

    public void update( Magnitud magnitud, int valor ){}

    public void updateRegla(){ regla.update();}

}
