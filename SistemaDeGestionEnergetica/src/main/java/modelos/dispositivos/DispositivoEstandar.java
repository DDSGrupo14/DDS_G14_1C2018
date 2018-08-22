package modelos.dispositivos;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DispositivoEstandar extends Dispositivo {

    @Expose
    private BigDecimal estimadoKWConsumidosPorHora;

    public DispositivoEstandar(TipoDispositivo tipo, String nombre, BigDecimal estimadoKWConsumidosPorHora) {
        super(tipo, nombre);
        this.estimadoKWConsumidosPorHora = estimadoKWConsumidosPorHora.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal consumidoEnUltimasHoras(Integer cantidad_horas) {
        return estimadoKWConsumidosPorHora.multiply( new BigDecimal( cantidad_horas ));
    }

    @Override
    public Dispositivo getObj() {
        return this;
    }
}
