package modelos.estados;

import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class AhorroDeEnergia implements Estado {

    private Logger logger;

    private Double porcentajeDeAhorro;

    public AhorroDeEnergia(Logger logger, Double porcentajeDeAhorro) {
        this.logger = logger;
        this.porcentajeDeAhorro = porcentajeDeAhorro;
    }

    @Override
    public boolean estasEncendido() {
        return true;
    }

    @Override
    public Estado encender( String nombreDispositivo ) {

        logger.debug("Encendiendo dispositivo: " + nombreDispositivo);

        return new Encendido( logger );
    }

    @Override
    public Estado apagar( String nombreDispositivo) {

        logger.debug("Apagando dispositivo: " + nombreDispositivo );

        return new Apagado( logger );
    }

    @Override
    public Estado ahorrarEnergia(Double porcentajeAhorro, String nombreDipositivo) {

        logger.debug("El dispositivo " + nombreDipositivo + " ya se encuentra en ahorro de energia.");

        return this;
    }

    @Override
    public BigDecimal porcentajeConsumo() {
        return new BigDecimal( 1 - porcentajeDeAhorro/100);
    }
}
