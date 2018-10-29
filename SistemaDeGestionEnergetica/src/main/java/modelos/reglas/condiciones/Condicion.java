package modelos.reglas.condiciones;

import com.deliveredtechnologies.rulebook.model.rulechain.cor.CoRRuleBook;
import modelos.reglas.reglas.Regla;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "condicion")
public class Condicion extends CoRRuleBook<Boolean> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "condicion_id", unique = true)
    private int condicion_id;

    @Column
    private int operador;
    @Column
    private Integer limite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regla_id")
    private Regla regla;

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

    public Condicion getClaseConcreta(){
        return null;
    }
}
