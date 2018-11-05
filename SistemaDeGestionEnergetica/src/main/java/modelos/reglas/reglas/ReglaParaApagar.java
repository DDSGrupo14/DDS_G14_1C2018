package modelos.reglas.reglas;

import javax.persistence.Entity;

@Entity
public class ReglaParaApagar extends Regla {

    public ReglaParaApagar() {
    }

    @Override
    public void actuar(){

        getActuador().apagar();

    }


}
