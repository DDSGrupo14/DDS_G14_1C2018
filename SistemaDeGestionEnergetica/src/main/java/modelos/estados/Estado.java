package modelos.estados;

import java.math.BigDecimal;

public interface Estado {

    Estado encender( String nombreDispositivo);

    Estado apagar( String nombreDispositivo );

    Estado ahorrarEnergia( Double porcentajeAhorro , String nombreDispositivo);

    BigDecimal porcentajeConsumo();

    boolean estasEncendido();

}
