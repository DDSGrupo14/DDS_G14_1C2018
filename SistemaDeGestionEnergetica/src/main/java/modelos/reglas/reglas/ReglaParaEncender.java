package modelos.reglas.reglas;

import javax.persistence.Entity;

@Entity
public class ReglaParaEncender extends Regla{

    public ReglaParaEncender() {
    }

    @Override
    public void actuar(){

        getActuador().encender();

    }
}
