package modelos.dispositivos;

import java.math.BigDecimal;

public interface Dispositivo {

    BigDecimal consumidoEnUltimasHoras( Integer tiempo );

    String nombreDispositivo();
}
