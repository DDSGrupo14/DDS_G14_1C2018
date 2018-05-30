package modelos.dispositivos.adaptadores;

import modelos.dispositivos.DispositivoEstandar;

import java.math.BigDecimal;

public class AdaptadorEstandar extends Adaptador {

    private DispositivoEstandar dispositivoEstandar;

    public AdaptadorEstandar( BigDecimal consumoPorHora, String nombre, DispositivoEstandar dispositivoEstandar) {

        super( consumoPorHora, nombre );
        this.dispositivoEstandar = dispositivoEstandar;
    }
}
