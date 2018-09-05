package modelos.dispositivos;

import json.BeanToJson;

import java.math.BigDecimal;

interface Dispositivo {

    BigDecimal consumidoEnUltimasHoras(Integer tiempo );

    BigDecimal consumoActual();

    public String getNombre();

}
