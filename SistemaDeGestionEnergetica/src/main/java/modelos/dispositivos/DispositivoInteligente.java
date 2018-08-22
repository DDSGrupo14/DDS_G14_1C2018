package modelos.dispositivos;

import com.google.gson.annotations.Expose;
import modelos.dispositivos.adaptadores.Adaptador;
import modelos.estados.Apagado;
import modelos.estados.Estado;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DispositivoInteligente  extends Dispositivo{

    private Estado estado;
    @Expose
    private Adaptador adaptador;
    @Expose
    private Double porcentajeAhorroEnergia;

    private final static Logger logger = LogManager.getLogger(DispositivoInteligente.class);

    public DispositivoInteligente( TipoDispositivo tipo, String nombre, Double porcentajeAhorroEnergia) {

        super(tipo, nombre);
        this.porcentajeAhorroEnergia = porcentajeAhorroEnergia;
        this.estado = new Apagado( logger );
    }

    public void setAdaptador(Adaptador adaptador) {
        this.adaptador = adaptador;
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
    public BigDecimal consumidoEnUltimasHoras(Integer cantHoras) {

        if( adaptador == null ){
            return obtenerConsumidoEn( cantHoras);
        } else {
            return adaptador.getConsumoPorHora().multiply(estado.porcentajeConsumo()).multiply( new BigDecimal(cantHoras ));
        }
    }

    public BigDecimal obtenerConsumidoEn(Integer cantHoras){

        return new BigDecimal(1).multiply(estado.porcentajeConsumo());
    }

/*
    public List<LogEntry> obtenerLogs( Integer cantHoras ){

        List<LogEntry> logs= Collections.emptyList();

        Scanner s = new Scanner(new FileReader(new File("/resources/logs/actividadDeDispositivos.logs")));

        while (s.hasNextLine()) {
            String linea = s.nextLine();

            String lineaPartida = linea.split("");
        }

        return logs;
    }
    */
}
