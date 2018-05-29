package modelos.dispositivos.adaptadores;

import modelos.dispositivos.DispositivoEstandar;

import java.math.BigDecimal;

public class AdaptadorEstandar extends Adaptador {

    private DispositivoEstandar dispositivoEstandar;

    public AdaptadorEstandar(DispositivoEstandar dispositivoEstandar, BigDecimal consumoPorHora) {
        this.dispositivoEstandar = dispositivoEstandar;

        this.setConsumoPorHora( consumoPorHora );
    }
}
