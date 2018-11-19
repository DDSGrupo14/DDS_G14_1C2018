package modelos.estados;

import modelos.dispositivos.DispositivoInteligente;

import java.math.BigDecimal;

public class AhorroDeEnergia extends Estado {

    public AhorroDeEnergia( DispositivoInteligente dispositivoInteligente) {
        super(dispositivoInteligente);
        this.setEstadoConcreto(EstadoConcreto.AHORROENERGIA);
        this.setUltimoEstado();
        setPorcentajeAhorro(dispositivoInteligente.getPorcentajeAhorroEnergia());
    }

    public AhorroDeEnergia(double porcentajeDeAhorro){
        super();
        setPorcentajeAhorro(porcentajeDeAhorro);
    }

    @Override
    public boolean estasEncendido() {
        return true;
    }

    @Override
    public Estado encender( ) {
        this.getConsumoDispositivoDAO().encenderDispositivo(getDispositivoInteligente());
        return new Encendido( getDispositivoInteligente() );
    }

    @Override
    public Estado apagar( ) {
        this.getConsumoDispositivoDAO().apagarDispositivo(getDispositivoInteligente());
        return new Apagado( getDispositivoInteligente());
    }

    @Override
    public Estado ahorrarEnergia( ) {

        return this;
    }

    @Override
    public double getPorcentajeAhorro() {
        return ( 1 - getPorcentajeAhorro()/100);
    }
}
