package modelos.estados;

import modelos.dispositivos.DispositivoInteligente;

import java.math.BigDecimal;

public class Apagado extends Estado {

    public Apagado(DispositivoInteligente dispositivoInteligente) {
        super(dispositivoInteligente);
        getConsumoDispositivoDAO().apagarDispositivo(dispositivoInteligente);
    }

    @Override
    public boolean estasEncendido() {
        return false;
    }

    @Override
    public Estado encender( ) {

        return new Encendido( getDispositivoInteligente());
    }

    @Override
    public Estado apagar( ) {

        return this;
    }

    @Override
    public Estado ahorrarEnergia( ) {

        return new AhorroDeEnergia( getDispositivoInteligente() );
    }

    @Override
    public BigDecimal porcentajeConsumo() {
        return new BigDecimal( 0 );
    }
}
