package modelos.estados;

import java.math.BigDecimal;

public interface Estado {

    Estado encender( );

    Estado apagar( );

    Estado ahorrarEnergia( Double porcentajeAhorro );

    BigDecimal porcentajeConsumo();

    boolean estasEncendido();

}
