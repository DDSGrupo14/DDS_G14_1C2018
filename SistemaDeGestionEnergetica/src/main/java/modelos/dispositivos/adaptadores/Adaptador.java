package modelos.dispositivos.adaptadores;

import com.google.gson.annotations.Expose;
import json.BeanToJson;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Adaptador extends BeanToJson<Adaptador> {

    @Expose
    private BigDecimal consumoPorHora;

    /*
    Uso este nombre para identificar cada adaptador, tiene que ser unico
     */
    @Expose
    private String nombreAdaptador;

    public Adaptador(BigDecimal consumoPorHora, String nombre) {

        this.consumoPorHora = consumoPorHora.setScale(2, RoundingMode.HALF_UP);
        this.nombreAdaptador = nombre;
    }

    public BigDecimal getConsumoPorHora() {
        return consumoPorHora;
    }

    public String getNombreAdaptador() {
        return nombreAdaptador;
    }

}
