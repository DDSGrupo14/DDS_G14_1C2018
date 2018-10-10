package modelos.dispositivos.adaptadores;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class AdaptadorAire extends Adaptador {

    public AdaptadorAire(BigDecimal consumoPorHora, String nombre) {
        super(consumoPorHora, nombre);
    }

    public AdaptadorAire(){}

    @Override
    public AdaptadorAire getObj() {
        return this;
    }
}
