package modelos.dispositivos;

import com.google.gson.annotations.Expose;
import json.BeanToJson;
import modelos.dispositivos.adaptadores.Adaptador;
import modelos.estados.Apagado;
import modelos.estados.Estado;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DispositivoInteligente extends BeanToJson<DispositivoInteligente> implements Dispositivo{

    private String nombre;

    private Estado estado;

    private Adaptador adaptador;

    private Double porcentajeAhorroEnergia;

    public DispositivoInteligente(String nombre, BigDecimal consumoPorHora,
                                  Adaptador adaptador, Double porcentajeAhorroEnergia) {
        this.nombre = nombre;
        this.adaptador = adaptador;
        this.estado = new Apagado();
        this.porcentajeAhorroEnergia = porcentajeAhorroEnergia;
    }

    public void encenderDispositivo(){ this.estado.encender(); }

    public void apagarDispositivo() { this.estado.apagar(); }

    public void pasarAhorroEnergia(){ this.estado.ahorrarEnergia( this.porcentajeAhorroEnergia); }

    public boolean estasEncendido(){ return this.estado.estasEncendido(); }

    public boolean estasApagado() { return !this.estado.estasEncendido(); }

    @Override
    public DispositivoInteligente getObj() {
        return this;
    }

    @Override
    public BigDecimal consumo(Integer tiempo) {
        return null;
    }
}
