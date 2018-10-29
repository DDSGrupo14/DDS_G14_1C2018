package modelos.estados;

import java.math.BigDecimal;

public class AhorroDeEnergia implements Estado {

    private Double porcentajeDeAhorro;

    public AhorroDeEnergia( Double porcentajeDeAhorro) {
        this.porcentajeDeAhorro = porcentajeDeAhorro;
    }

    @Override
    public boolean estasEncendido() {
        return true;
    }

    @Override
    public Estado encender( ) {

        return new Encendido( );
    }

    @Override
    public Estado apagar( ) {

        return new Apagado( );
    }

    @Override
    public Estado ahorrarEnergia(Double porcentajeAhorro ) {

        return this;
    }

    @Override
    public BigDecimal porcentajeConsumo() {
        return new BigDecimal( 1 - porcentajeDeAhorro/100);
    }
}
