package modelos.estados;

import java.math.BigDecimal;

public class Apagado implements Estado {

    public Apagado( ) {}

    @Override
    public boolean estasEncendido() {
        return false;
    }

    @Override
    public Estado encender( ) {

        return new Encendido( );
    }

    @Override
    public Estado apagar( ) {

        return this;
    }

    @Override
    public Estado ahorrarEnergia(Double porcentajeAhorro ) {

        return new AhorroDeEnergia( porcentajeAhorro );
    }

    @Override
    public BigDecimal porcentajeConsumo() {
        return new BigDecimal( 0 );
    }
}
