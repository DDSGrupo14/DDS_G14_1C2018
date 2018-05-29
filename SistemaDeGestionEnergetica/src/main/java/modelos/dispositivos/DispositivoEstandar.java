package modelos.dispositivos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DispositivoEstandar implements Dispositivo {

    private BigDecimal estimadoKWConsumidosPorHora;

    private String nombre;

    public DispositivoEstandar(BigDecimal estimadoKWConsumidosPorHora, String nombre) {
        this.estimadoKWConsumidosPorHora = estimadoKWConsumidosPorHora.setScale(2, RoundingMode.HALF_UP);
        this.nombre = nombre;
    }

    @Override
    public BigDecimal consumo(Integer tiempo) {
        return estimadoKWConsumidosPorHora;
    }
}
