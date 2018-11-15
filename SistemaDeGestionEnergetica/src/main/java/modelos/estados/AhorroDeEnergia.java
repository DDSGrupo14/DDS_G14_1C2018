package modelos.estados;

import modelos.dispositivos.DispositivoInteligente;

import java.math.BigDecimal;

public class AhorroDeEnergia extends Estado {

    public AhorroDeEnergia( DispositivoInteligente dispositivoInteligente) {

        super(dispositivoInteligente);
        getConsumoDispositivoDAO().ahorroEnergiaDispositivo(dispositivoInteligente);
    }

    @Override
    public boolean estasEncendido() {
        return true;
    }

    @Override
    public Estado encender( ) {

        return new Encendido( getDispositivoInteligente() );
    }

    @Override
    public Estado apagar( ) {

        return new Apagado( getDispositivoInteligente());
    }

    @Override
    public Estado ahorrarEnergia( ) {

        return this;
    }

    @Override
    public BigDecimal porcentajeConsumo() {
        return new BigDecimal( 1 - getDispositivoInteligente().getPorcentajeAhorroEnergia()/100);
    }
}
