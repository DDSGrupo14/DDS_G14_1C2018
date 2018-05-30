package modelos.dispositivos;

import com.google.gson.annotations.Expose;
import json.BeanToJson;
import modelos.dispositivos.adaptadores.Adaptador;
import modelos.estados.Apagado;
import modelos.estados.Estado;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.math.BigDecimal;

public class DispositivoInteligente extends BeanToJson<DispositivoInteligente> implements Dispositivo{

    private Estado estado;

    private Adaptador adaptador;

    private Double porcentajeAhorroEnergia;

    private final static Logger logger = LogManager.getLogger(DispositivoInteligente.class);


    public DispositivoInteligente( Adaptador adaptador, Double porcentajeAhorroEnergia) {
        this.adaptador = adaptador;
        this.porcentajeAhorroEnergia = porcentajeAhorroEnergia;
        this.estado = new Apagado( logger );
    }

    public String nombreDispositivo() { return adaptador.getNombre(); }

    public void encenderDispositivo(){ estado.encender( nombreDispositivo() ); }

    public void apagarDispositivo() { estado.apagar( nombreDispositivo() ); }

    public void pasarAhorroEnergia(){ estado.ahorrarEnergia( porcentajeAhorroEnergia, nombreDispositivo() ); }

    public boolean estasEncendido(){ return estado.estasEncendido(); }

    public boolean estasApagado() { return !estado.estasEncendido(); }

    @Override
    public DispositivoInteligente getObj() {
        return this;
    }

    @Override
    public BigDecimal consumo(Integer tiempo) {

        return adaptador.getConsumoPorHora().multiply(estado.porcentajeConsumo()).multiply( new BigDecimal(tiempo ));
    }

}
