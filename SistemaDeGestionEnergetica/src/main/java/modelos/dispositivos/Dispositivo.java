package modelos.dispositivos;

import java.math.BigDecimal;

interface Dispositivo {

    BigDecimal consumidoEnUltimasHoras(Integer tiempo );

    BigDecimal getConsumoEstimadoKWh();

    String getNombre();

    String getEquipoConcreto();

}
