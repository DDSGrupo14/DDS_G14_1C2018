package modelos.estados;

import modelos.dispositivos.DispositivoInteligente;
import utilidades.ConsumoDispositivoDAO;

import java.math.BigDecimal;

public abstract class Estado {

    private DispositivoInteligente dispositivoInteligente;
    private final ConsumoDispositivoDAO consumoDispositivoDAO = new ConsumoDispositivoDAO();

    public Estado(DispositivoInteligente dispositivoInteligente){
        this.dispositivoInteligente = dispositivoInteligente;
    }

    public DispositivoInteligente getDispositivoInteligente() {
        return dispositivoInteligente;
    }

    public ConsumoDispositivoDAO getConsumoDispositivoDAO() {
        return consumoDispositivoDAO;
    }

    public Estado encender( ){ return null; }

    public Estado apagar( ){return null; }

    public Estado ahorrarEnergia( ){return null; }

    public BigDecimal porcentajeConsumo(){ return null; }

    public boolean estasEncendido(){ return false; }

}
