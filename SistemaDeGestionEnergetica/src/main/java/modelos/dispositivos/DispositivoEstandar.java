package modelos.dispositivos;

import com.google.gson.annotations.Expose;
import json.BeanToJson;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DispositivoEstandar extends BeanToJson<DispositivoEstandar> implements Dispositivo {

    @Expose
    private BigDecimal estimadoKWConsumidosPorHora;
    @Expose
    private String nombre;

    @Override
    public String nombreDispositivo() {
        return nombre;
    }

    public DispositivoEstandar(BigDecimal estimadoKWConsumidosPorHora, String nombre) {
        this.estimadoKWConsumidosPorHora = estimadoKWConsumidosPorHora.setScale(2, RoundingMode.HALF_UP);
        this.nombre = nombre;
    }

    @Override
    public BigDecimal consumidoEnUltimasHoras(Integer cantidad_horas) {
        return estimadoKWConsumidosPorHora.multiply( new BigDecimal( cantidad_horas ));
    }

    @Override
    public DispositivoEstandar getObj() {
        return this;
    }
}
