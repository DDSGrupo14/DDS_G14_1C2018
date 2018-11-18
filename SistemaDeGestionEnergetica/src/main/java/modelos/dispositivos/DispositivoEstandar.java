package modelos.dispositivos;

import com.google.gson.annotations.Expose;
import json.BeanToJson;
import modelos.dispositivos.adaptadores.Adaptador;
import modelos.usuarios.Domicilio;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "dispositivoEstandar")
public class DispositivoEstandar extends BeanToJson<Dispositivo> implements Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dest_id", unique = true)
    private int dest_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dom_id")
    private Domicilio domicilio;

    @Expose
    @Column(nullable = false)
    private String nombre;

    @OneToOne(
            mappedBy = "dispositivoEstandar",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Adaptador adaptador;

    @Expose
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tdisp_id")
    private TipoDispositivo tipoDispositivo;

    public DispositivoEstandar(String nombre, TipoDispositivo tipoDispositivo) {
        this.nombre = nombre;
        this.tipoDispositivo = tipoDispositivo;
    }

    public DispositivoEstandar(){}

    public TipoDispositivo getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public int getDest_id() {
        return dest_id;
    }

    public void setDest_id(int dest_id) {
        this.dest_id = dest_id;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Adaptador getAdaptador() {
        return adaptador;
    }

    public void setAdaptador(Adaptador adaptador) {
        this.adaptador = adaptador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getConsumoEstimadoKWh() {
        return tipoDispositivo.getConsumoEstimadoKWh();
    }

    @Override
    public BigDecimal consumidoEnUltimasHoras(Integer cantidad_horas) {
        return getConsumoEstimadoKWh().multiply( new BigDecimal( cantidad_horas ));
    }

    @Override
    public DispositivoEstandar getObj() {
        return this;
    }

    /*
    Este getter esta asi para que sea igual para todos los dispositivos
     */
    public BigDecimal getConsumoActual() {
        return getConsumoEstimadoKWh();
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getEquipoConcreto(){ return tipoDispositivo.getEquipoConcreto();}
}
