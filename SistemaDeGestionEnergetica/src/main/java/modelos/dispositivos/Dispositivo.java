package modelos.dispositivos;

import java.math.BigDecimal;

public interface Dispositivo {

    BigDecimal consumo( Integer tiempo );

    String nombreDispositivo();
}
