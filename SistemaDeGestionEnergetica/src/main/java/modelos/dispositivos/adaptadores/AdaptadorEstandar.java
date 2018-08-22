package modelos.dispositivos.adaptadores;

import com.google.gson.annotations.Expose;
import modelos.dispositivos.DispositivoEstandar;

import java.math.BigDecimal;

public class AdaptadorEstandar extends Adaptador {

    @Expose
    private DispositivoEstandar dispositivoEstandar;

    public AdaptadorEstandar( BigDecimal consumoPorHora, String nombre) {

        super( consumoPorHora, nombre );
    }

    public void setDispositivoEstandar(DispositivoEstandar dispositivoEstandar) {
        this.dispositivoEstandar = dispositivoEstandar;
    }

    @Override
    public AdaptadorEstandar getObj() {
        return this;
    }
}
