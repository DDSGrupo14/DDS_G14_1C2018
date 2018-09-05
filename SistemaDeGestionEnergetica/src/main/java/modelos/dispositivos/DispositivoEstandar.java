package modelos.dispositivos;

import com.google.gson.annotations.Expose;
import json.BeanToJson;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DispositivoEstandar extends BeanToJson<Dispositivo> implements Dispositivo {

    @Expose
    private String nombre;
    @Expose
    private BigDecimal estimadoKWConsumidosPorHora;

    public DispositivoEstandar(String nombre, BigDecimal estimadoKWConsumidosPorHora) {
        this.nombre = nombre;
        this.estimadoKWConsumidosPorHora = estimadoKWConsumidosPorHora.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal consumidoEnUltimasHoras(Integer cantidad_horas) {
        return estimadoKWConsumidosPorHora.multiply( new BigDecimal( cantidad_horas ));
    }

    @Override
    public DispositivoEstandar getObj() {
        return this;
    }

    /*
    Este getter esta asi para que sea igual para todos los dispositivos
     */
    public BigDecimal consumoActual() {
        return estimadoKWConsumidosPorHora;
    }

    @Override
    public String getNombre() {
        return null;
    }
}
