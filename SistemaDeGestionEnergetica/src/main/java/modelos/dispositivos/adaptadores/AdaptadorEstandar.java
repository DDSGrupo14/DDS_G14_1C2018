package modelos.dispositivos.adaptadores;

import com.google.gson.annotations.Expose;
import modelos.dispositivos.DispositivoEstandar;

import java.math.BigDecimal;

public class AdaptadorEstandar extends Adaptador {

    @Expose
    private DispositivoEstandar dispositivoEstandar;

    public AdaptadorEstandar( BigDecimal consumoPorHora, String nombre, DispositivoEstandar dispositivoEstandar) {

        super( consumoPorHora, nombre );
        this.dispositivoEstandar = dispositivoEstandar;
    }

    @Override
    public Adaptador getObj() {
        return this;
    }
}
