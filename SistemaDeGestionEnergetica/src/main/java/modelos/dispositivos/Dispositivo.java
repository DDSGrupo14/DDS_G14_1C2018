package modelos.dispositivos;

import com.google.gson.annotations.Expose;
import json.BeanToJson;

import java.math.BigDecimal;

public abstract class Dispositivo extends BeanToJson<Dispositivo> {

    @Expose
    private final TipoDispositivo tipoDispositivo;

    @Expose
    private String nombre;

    public Dispositivo(TipoDispositivo tipoDispositivo, String nombre) {
        this.tipoDispositivo = tipoDispositivo;
        this.nombre = nombre;
    }

    BigDecimal consumidoEnUltimasHoras(Integer tiempo ){return null;}

    public String getNombre() {
        return nombre;
    }

    public Integer getUsoMensualMinimo(){ return tipoDispositivo.getUsoMensualMinimo();}

    public Integer getUsoMensualMaximo(){ return tipoDispositivo.getUsoMensualMaximo();}

    public Double getConsumoEstimadoKWh(){ return tipoDispositivo.getConsumoEstimadoKWh();}

    public String getEquipoConcreto(){ return tipoDispositivo.getEquipoConcreto();}

}
