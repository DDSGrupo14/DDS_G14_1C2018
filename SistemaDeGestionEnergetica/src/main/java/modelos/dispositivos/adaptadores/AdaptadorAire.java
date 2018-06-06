package modelos.dispositivos.adaptadores;

import java.math.BigDecimal;

public class AdaptadorAire extends Adaptador {


    public AdaptadorAire(BigDecimal consumoPorHora, String nombre) {
        super(consumoPorHora, nombre);
    }

    @Override
    public Adaptador getObj() {
        return this;
    }
}
