package modelos.dispositivos;

import java.math.BigDecimal;

interface Dispositivo {

    BigDecimal consumidoEnUltimasHoras(Integer tiempo );

    BigDecimal getConsumoActual();

    BigDecimal getConsumoEstimadoKWh();

    String getNombre();

    String getEquipoConcreto();

}
