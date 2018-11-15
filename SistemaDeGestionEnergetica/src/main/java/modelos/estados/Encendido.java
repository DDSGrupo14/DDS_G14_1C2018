package modelos.estados;

import modelos.dispositivos.DispositivoInteligente;

import java.math.BigDecimal;

public class Encendido extends Estado {

    public Encendido(DispositivoInteligente dispositivoInteligente) {
        super(dispositivoInteligente);
        getConsumoDispositivoDAO().encenderDispositivo(dispositivoInteligente);
    }

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

        return new Apagado(getDispositivoInteligente() );
    }

    @Override
    public Estado ahorrarEnergia( ) {

        return new AhorroDeEnergia( getDispositivoInteligente() );
    }

    @Override
    public BigDecimal porcentajeConsumo() {
        return new BigDecimal( 1 );
    }
}
