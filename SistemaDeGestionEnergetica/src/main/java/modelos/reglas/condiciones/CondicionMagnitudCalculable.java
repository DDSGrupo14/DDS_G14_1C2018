package modelos.reglas.condiciones;

import com.deliveredtechnologies.rulebook.lang.RuleBuilder;

import javax.persistence.*;

@Entity
@Table(name = "condicion" )
public class CondicionMagnitudCalculable extends Condicion {

    public CondicionMagnitudCalculable(){}

    public CondicionMagnitudCalculable(int operador, Integer limite){
        super(operador, limite);
    }

    @Override
    public CondicionMagnitudCalculable getClaseConcreta(){
        return this;
    }

    @Override
    public void defineRules() {
        /*
            Defino regla para temperatura
         */
        addRule(RuleBuilder.create().withFactType(int.class).withResultType(Boolean.class)
                .when(facts -> Operador.obtenerOperador(this.getOperador())
                        .calcular( this.getLimite(),facts.getIntVal("valor")))
                .using("valor")
                .then((facts, result) -> result.setValue( true ))
                .build());
    }

    }
