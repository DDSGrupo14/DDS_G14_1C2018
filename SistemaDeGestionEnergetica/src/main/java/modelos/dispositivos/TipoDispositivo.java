package modelos.dispositivos;

public class TipoDispositivo {

    private final String equipoConcreto;

    private final int usoMensualMinimo;

    private final int usoMensualMaximo;

    private final Double consumoEstimadoKWh;

    public TipoDispositivo(String equipoConcreto, int usoMensualMinimo, int usoMensualMaximo, Double consumoEstimadoKWh) {
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

    public Double getConsumoEstimadoKWh() {
        return consumoEstimadoKWh;
    }
}
