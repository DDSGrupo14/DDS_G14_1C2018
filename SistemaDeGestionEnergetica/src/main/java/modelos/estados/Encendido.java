package modelos.estados;

import java.math.BigDecimal;

public class Encendido implements Estado {


    public Encendido() { }

    @Override
    public boolean estasEncendido() {
        return true;
    }

    @Override
    public Estado encender( ) {

        return this;
    }

    @Override
    public Apagado apagar( ) {

        return new Apagado( );
    }

    @Override
    public Estado ahorrarEnergia( Double porcentajeAhorro ) {

        return new AhorroDeEnergia( porcentajeAhorro );
    }

    @Override
    public BigDecimal porcentajeConsumo() {
        return new BigDecimal( 1 );
    }
}
