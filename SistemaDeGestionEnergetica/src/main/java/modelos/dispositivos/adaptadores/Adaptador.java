package modelos.dispositivos.adaptadores;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Adaptador {

    private BigDecimal consumoPorHora;

    private String nombre;

    public BigDecimal getConsumoPorHora() {
        return consumoPorHora;
    }

    public String getNombre() {
        return nombre;
    }

    public Adaptador(BigDecimal consumoPorHora, String nombre) {
        this.consumoPorHora = consumoPorHora.setScale(2, RoundingMode.HALF_UP);
        this.nombre = nombre;
    }
}
