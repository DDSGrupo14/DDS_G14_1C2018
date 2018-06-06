package modelos.estados;

import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class Apagado implements Estado {

    private Logger logger;

    public Apagado(Logger logger) {
        this.logger = logger;
    }

    @Override
    public boolean estasEncendido() {
        return false;
    }

    @Override
    public Encendido encender( String nombreDispositivo ) {

        logger.debug("Encender : " + nombreDispositivo  );

        return new Encendido( logger );
    }

    @Override
    public Estado apagar( String nombreDispositivo ) {

        logger.debug("El dispositivo " + nombreDispositivo + "ya se encuentra apagado.");

        return this;
    }

    @Override
    public Estado ahorrarEnergia(Double porcentajeAhorro, String nombreDispositivo ) {

        logger.debug("Ahorrar : " + nombreDispositivo );

        return new AhorroDeEnergia( logger, porcentajeAhorro );
    }

    @Override
    public BigDecimal porcentajeConsumo() {
        return new BigDecimal( 0 );
    }
}
