package modelos.estados;

import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class Encendido implements Estado {

    private Logger logger;

    public Encendido(Logger logger) {
        this.logger = logger;
    }

    @Override
    public boolean estasEncendido() {
        return true;
    }

    @Override
    public Estado encender( String nombreDispositivo ) {

        this.logger.debug("El dispositivo " + nombreDispositivo + " ya se encuentra encendido.");

        return this;
    }

    @Override
    public Apagado apagar( String nombreDispositivo ) {

        logger.debug("Apagar : " + nombreDispositivo );

        return new Apagado( logger );
    }

    @Override
    public Estado ahorrarEnergia( Double porcentajeAhorro, String nombreDispositivo ) {

        logger.debug("Ahorrar : " + nombreDispositivo );

        return new AhorroDeEnergia( logger, porcentajeAhorro );
    }

    @Override
    public BigDecimal porcentajeConsumo() {
        return new BigDecimal( 1 );
    }
}
