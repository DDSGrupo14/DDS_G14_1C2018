package modelos.reglas.reglas;

import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.lang.RuleBookBuilder;
import com.deliveredtechnologies.rulebook.model.RuleBook;
import modelos.reglas.condiciones.Condicion;
import modelos.reglas.sensores.Magnitud;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class ApagarSegunTemperatura extends Regla {

    @Transient
    static Boolean resultado = true;


    public ApagarSegunTemperatura(List<Condicion> condiciones) {

        getCondiciones().addAll(condiciones);
    }

    public ApagarSegunTemperatura() {
    }

    private void initRegla(){

        for (Condicion condicion: getCondiciones() ) {
            condiciones_a_cumplir.add(RuleBookBuilder.create(condicion.getClaseConcreta().getClass())
                    .withResultType(Boolean.class)
                    .withDefaultResult(false).build());
        }
    }

    @Override
    public void update(Magnitud tipoMagnitud, int valor){

        NameValueReferableMap facts = new FactMap();
        facts.setValue("valor", valor);

        for (RuleBook cond: condiciones_a_cumplir) {
            cond.run(facts);
        }

        condiciones_a_cumplir.forEach(cond -> cond.getResult().ifPresent(
                result -> { resultado =resultado && (boolean) result;}
        ));

        if ( resultado ) actuar();
    }

    @Override
    public void actuar(){

        if(condiciones_a_cumplir == null){
            initRegla();
        } else {
            condiciones_a_cumplir.clear();
            initRegla();
        }

        getActuador().apagar();

    }


}
