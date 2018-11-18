package modelos.estados;

import modelos.dispositivos.DispositivoInteligente;
import modelos.dao.ConsumoDispositivoDAO;

import java.math.BigDecimal;

public abstract class Estado {

    private EstadoConcreto estadoConcreto;

    private DispositivoInteligente dispositivoInteligente;

    private final ConsumoDispositivoDAO consumoDispositivoDAO = new ConsumoDispositivoDAO();

    public Estado(DispositivoInteligente dispositivoInteligente){
        this.dispositivoInteligente = dispositivoInteligente;
    }

    public DispositivoInteligente getDispositivoInteligente() {
        return dispositivoInteligente;
    }

    public EstadoConcreto getEstadoConcreto() {
        return estadoConcreto;
    }

    public void setEstadoConcreto(EstadoConcreto estadoConcreto) {
        this.estadoConcreto = estadoConcreto;
    }

    public ConsumoDispositivoDAO getConsumoDispositivoDAO() {
        return consumoDispositivoDAO;
    }

    public Estado encender( ){ return null; }

    public Estado apagar( ){return null; }

    public Estado ahorrarEnergia( ){return null; }

    public BigDecimal porcentajeConsumo(){ return null; }

    public boolean estasEncendido(){ return false; }

    public int geteEstadoId(){ return estadoConcreto.getValue(); }

    public void setUltimoEstado(){
        dispositivoInteligente.setUltimoEstado(estadoConcreto.getValue());
    }

    @Override
    public String toString(){
        return getEstadoConcreto().getNombreEstadoConcreto();
    }

}
