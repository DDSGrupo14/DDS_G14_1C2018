package modelos;

import com.google.gson.annotations.Expose;
import json.BeanToJson;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Dispositivo extends BeanToJson<Dispositivo> {

    @Expose
    private String nombre;
    @Expose
    private BigDecimal consumoPorHora;
    @Expose
    private Boolean encendido;

    public Dispositivo(String nombre, BigDecimal consumoPorHora, Boolean encendido) {
        this.nombre = nombre;
        this.consumoPorHora = consumoPorHora.setScale(2, RoundingMode.HALF_UP);
        this.encendido = encendido;
    }

    public Boolean getEncendido() {
        return encendido;
    }

    public void setEncendido(Boolean encendido) {
        this.encendido = encendido;
    }

    @Override
    public Dispositivo getObj() {
        return this;
    }
}
