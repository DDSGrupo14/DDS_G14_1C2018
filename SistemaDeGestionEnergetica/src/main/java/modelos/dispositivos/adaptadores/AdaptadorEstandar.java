package modelos.dispositivos.adaptadores;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class AdaptadorEstandar extends Adaptador {

    public AdaptadorEstandar( BigDecimal consumoPorHora, String nombre) {

        super( consumoPorHora, nombre );
    }

    public AdaptadorEstandar(){}

    @Override
    public AdaptadorEstandar getObj() {
        return this;
    }
}
