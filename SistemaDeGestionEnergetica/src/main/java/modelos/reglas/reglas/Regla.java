package modelos.reglas.reglas;

import modelos.reglas.actuadores.Actuador;
import modelos.reglas.condiciones.Condicion;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "regla")
public class Regla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regla_id", unique = true)
    private int regla_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "act_id")
    private Actuador actuador;

    @OneToMany(
            mappedBy = "regla",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Condicion> condiciones = new HashSet<>();

    @Column
    private String codigoRegla;

    public Regla(){}

    public int getRegla_id() {
        return regla_id;
    }

    public void setRegla_id(int regla_id) {
        this.regla_id = regla_id;
    }

    public String getCodigoRegla() {
        return codigoRegla;
    }

    public void setCodigoRegla(String codigoRegla) {
        this.codigoRegla = codigoRegla;
    }

    public Set<Condicion> getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(Set<Condicion> condiciones) {

        if (condiciones == null)
            this.condiciones = condiciones;
        else
            condiciones.addAll(condiciones);

        condiciones.forEach(condicion -> condicion.setRegla(this));
    }

    public void agregarCondicion(Condicion condicion){
        condiciones.add(condicion);
    }

    public void quitarCondicion( Condicion condicion) { condiciones.remove(condicion);}

    public Actuador getActuador() {
        return actuador;
    }

    public void setActuador(Actuador actuador) {
        this.actuador = actuador;
    }

    public void actuar(){}

    public void update(){
        if(condiciones.stream().allMatch(Condicion::getCondicionCumplida))
            actuar();
    }
}
