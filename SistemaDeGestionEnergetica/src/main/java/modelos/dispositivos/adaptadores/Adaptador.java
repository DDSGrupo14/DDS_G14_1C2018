package modelos.dispositivos.adaptadores;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Adaptador {

    private BigDecimal consumoPorHora;

    private String nombre;

    public BigDecimal getConsumoPorHora() {
        return consumoPorHora;
    }

    public void setConsumoPorHora(BigDecimal consumoPorHora) {
        this.consumoPorHora = consumoPorHora.setScale(2, RoundingMode.HALF_UP);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
