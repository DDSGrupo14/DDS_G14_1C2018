package modelos.dispositivos;

import com.google.gson.annotations.Expose;
import json.BeanToJson;
import modelos.dispositivos.adaptadores.Adaptador;
import modelos.estados.Apagado;
import modelos.estados.Estado;

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
    //@MapsId
    @JoinColumn(name = "tdisp_id")
    private TipoDispositivo tipoDispositivo;
    @OneToMany(
            mappedBy = "dispositivoInteligente",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ConsumoDispositivo> consumoTotal;
    @Transient
    private BigDecimal consumoActual;

    public DispositivoInteligente(TipoDispositivo tipo, String nombre, Double porcentajeAhorroEnergia) {

        this.tipoDispositivo = tipo;
        this.nombre = nombre;
        this.porcentajeAhorroEnergia = porcentajeAhorroEnergia;
        this.estado = new Apagado( );
        this.consumoTotal = new ArrayList<ConsumoDispositivo>();
    }

    public DispositivoInteligente(){}

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

    public void agregarConsumo(ConsumoDispositivo consumo){

    }

    public List<ConsumoDispositivo> getConsumoTotal() {
        return consumoTotal;
    }

    public void setConsumoTotal(List<ConsumoDispositivo> consumoTotal) {
        this.consumoTotal = consumoTotal;
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

    public void pasarAhorroEnergia(){ estado = estado.ahorrarEnergia( porcentajeAhorroEnergia ); }

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

    @Override
    public BigDecimal consumoActual() {
        return getConsumoActual();
    }

    public void setConsumoActual(BigDecimal consumoActual) {
        this.consumoActual = consumoActual;
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

    public BigDecimal getConsumoActual() {
        return consumoActual;
    }

    public Integer getUsoMensualMinimo(){ return tipoDispositivo.getUsoMensualMinimo();}

    public Integer getUsoMensualMaximo(){ return tipoDispositivo.getUsoMensualMaximo();}

    public BigDecimal getConsumoEstimadoKWh(){ return tipoDispositivo.getConsumoEstimadoKWh();}

    public String getEquipoConcreto(){ return tipoDispositivo.getEquipoConcreto();}
}
