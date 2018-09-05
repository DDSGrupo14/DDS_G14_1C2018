package modelos.dispositivos;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class TipoDispositivo {

    @Expose
    private final String equipoConcreto;
    @Expose
    private final int usoMensualMinimo;
    @Expose
    private final int usoMensualMaximo;
    @Expose
    private final BigDecimal consumoEstimadoKWh;

    public TipoDispositivo(String equipoConcreto, int usoMensualMinimo, int usoMensualMaximo, BigDecimal consumoEstimadoKWh) {
        this.equipoConcreto = equipoConcreto;
        this.usoMensualMinimo = usoMensualMinimo;
        this.usoMensualMaximo = usoMensualMaximo;
        this.consumoEstimadoKWh = consumoEstimadoKWh;
    }

    public String getEquipoConcreto() {
        return equipoConcreto;
    }

    public int getUsoMensualMinimo() {
        return usoMensualMinimo;
    }

    public int getUsoMensualMaximo() {
        return usoMensualMaximo;
    }

    public BigDecimal getConsumoEstimadoKWh() {
        return consumoEstimadoKWh;
    }
}
