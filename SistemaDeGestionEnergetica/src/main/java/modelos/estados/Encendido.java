package modelos.estados;

import modelos.dispositivos.DispositivoInteligente;

public class Encendido extends Estado {

    public Encendido(DispositivoInteligente dispositivoInteligente) {
        super(dispositivoInteligente);
        this.setEstadoConcreto(EstadoConcreto.ENCENDIDO);
        this.setUltimoEstado();
    }

    public Encendido(){
        super();
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
        this.getConsumoDispositivoDAO().apagarDispositivo(getDispositivoInteligente());
        return new Apagado(getDispositivoInteligente() );
    }

    @Override
    public Estado ahorrarEnergia( ) {
        this.getConsumoDispositivoDAO().ahorroEnergiaDispositivo(getDispositivoInteligente());
        return new AhorroDeEnergia( getDispositivoInteligente() );
    }

    @Override
    public double getPorcentajeAhorro() {
        return 1.0;
    }

}
