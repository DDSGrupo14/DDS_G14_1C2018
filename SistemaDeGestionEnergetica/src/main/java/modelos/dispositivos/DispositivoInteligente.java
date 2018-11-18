package modelos.dispositivos;

import com.google.gson.annotations.Expose;
import json.BeanToJson;
import modelos.dispositivos.adaptadores.Adaptador;
import modelos.estados.Apagado;
import modelos.estados.Estado;

import modelos.estados.EstadoConcreto;
import modelos.usuarios.Domicilio;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dispositivoInteligente")
public class DispositivoInteligente extends BeanToJson<Dispositivo> implements Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dint_id", unique = true)
    private int dint_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dom_id")
    private Domicilio domicilio;

    @Expose
    @Column(nullable = false)
    private String nombre;
    @Transient
    private Estado estado;
    @Column
    private int ultimoEstado = -1;
    @Expose
    @OneToOne(
            mappedBy = "dispositivoInteligente",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Adaptador adaptador;
    @Expose
    @Column
    private Double porcentajeAhorroEnergia;
    @Expose
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tdisp_id")
    private TipoDispositivo tipoDispositivo;
    @OneToMany(
            mappedBy = "dispositivoInteligente",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ConsumoDispositivo> consumoTotal = new ArrayList<>();

    public DispositivoInteligente(TipoDispositivo tipo, String nombre, Double porcentajeAhorroEnergia) {

        this.tipoDispositivo = tipo;
        this.nombre = nombre;
        this.porcentajeAhorroEnergia = porcentajeAhorroEnergia;
    }

    public DispositivoInteligente(){}

    public void iniciarDispositivoInteligente(){

        if( (this.estado == null) && (this.ultimoEstado == -1))
            this.estado = new Apagado(this );
        else
            this.estado = EstadoConcreto.obtenerEstadoConcreto(ultimoEstado).obtenerEstado(this);
    }

    public void setAdaptador(Adaptador adaptador) {
        this.adaptador = adaptador;
        adaptador.setDispositivoInteligente(this);
    }

    public Adaptador getAdaptador() {
        return adaptador;
    }

    public int getDint_id() {
        return dint_id;
    }

    public void setDint_id(int dint_id) {
        this.dint_id = dint_id;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public List<ConsumoDispositivo> getConsumoTotal() {
        return consumoTotal;
    }

    public void setConsumoTotal(List<ConsumoDispositivo> consumoTotal) {
        this.consumoTotal = consumoTotal;
        //consumoTotal.forEach(cons -> cons.setDispositivoInteligente(this));
    }

    public int getUltimoEstado() {
        return ultimoEstado;
    }

    public void setUltimoEstado(int ultimoEstado) {
        this.ultimoEstado = ultimoEstado;
    }

    @Override
    public String getNombre() {

        if(adaptador!=null)
            return adaptador.getNombreAdaptador();
        else
            return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPorcentajeAhorroEnergia() {
        return porcentajeAhorroEnergia;
    }

    public void setPorcentajeAhorroEnergia(Double porcentajeAhorroEnergia) {
        this.porcentajeAhorroEnergia = porcentajeAhorroEnergia;
    }

    public void encenderDispositivo(){ estado = estado.encender( ); }

    public void apagarDispositivo() { estado = estado.apagar( ); }

    public void pasarAhorroEnergia(){ estado = estado.ahorrarEnergia( ); }

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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoDispositivo getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    @Override
    public BigDecimal getConsumoActual() {
        return tipoDispositivo.getConsumoEstimadoKWh().multiply(estado.porcentajeConsumo());
    }

    public Integer getUsoMensualMinimo(){ return tipoDispositivo.getUsoMensualMinimo();}

    public Integer getUsoMensualMaximo(){ return tipoDispositivo.getUsoMensualMaximo();}

    public BigDecimal getConsumoEstimadoKWh(){ return tipoDispositivo.getConsumoEstimadoKWh();}

    @Override
    public String getEquipoConcreto(){ return tipoDispositivo.getEquipoConcreto();}
}
