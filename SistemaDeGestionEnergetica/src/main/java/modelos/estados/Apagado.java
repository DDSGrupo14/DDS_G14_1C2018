package modelos.estados;

import modelos.dispositivos.DispositivoInteligente;

public class Apagado extends Estado {

    public Apagado(DispositivoInteligente dispositivoInteligente) {
        super(dispositivoInteligente);
        this.setEstadoConcreto(EstadoConcreto.APAGADO);
        this.setUltimoEstado();
    }

    public Apagado(){
        super();
    }

    @Override
    public boolean estasEncendido() {
        return false;
    }

    @Override
    public Estado encender( ) {
        this.getConsumoDispositivoDAO().encenderDispositivo(getDispositivoInteligente());
        return new Encendido( getDispositivoInteligente());
    }

    @Override
    public Estado apagar( ) {

        return this;
    }

    @Override
    public Estado ahorrarEnergia( ) {
        this.getConsumoDispositivoDAO().ahorroEnergiaDispositivo(getDispositivoInteligente());
        return new AhorroDeEnergia( getDispositivoInteligente() );
    }

    @Override
    public double getPorcentajeAhorro() {
        return 0.0;
    }

}
