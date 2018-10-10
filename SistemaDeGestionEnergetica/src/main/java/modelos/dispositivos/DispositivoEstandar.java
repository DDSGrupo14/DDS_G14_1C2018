package modelos.dispositivos;

import com.google.gson.annotations.Expose;
import json.BeanToJson;
import modelos.dispositivos.adaptadores.Adaptador;

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

    @Expose
    @Column(nullable = false)
    private String nombre;
    @Expose
    @Column(nullable = false)
    private BigDecimal estimadoKWConsumidosPorHora;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Adaptador adaptador;

    public DispositivoEstandar(String nombre, BigDecimal estimadoKWConsumidosPorHora) {
        this.nombre = nombre;
        this.estimadoKWConsumidosPorHora = estimadoKWConsumidosPorHora.setScale(2, RoundingMode.HALF_UP);
    }

    public DispositivoEstandar(){}

    public int getDest_id() {
        return dest_id;
    }

    public void setDest_id(int dest_id) {
        this.dest_id = dest_id;
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

    public BigDecimal getEstimadoKWConsumidosPorHora() {
        return estimadoKWConsumidosPorHora;
    }

    public void setEstimadoKWConsumidosPorHora(BigDecimal estimadoKWConsumidosPorHora) {
        this.estimadoKWConsumidosPorHora = estimadoKWConsumidosPorHora;
    }

    @Override
    public BigDecimal consumidoEnUltimasHoras(Integer cantidad_horas) {
        return estimadoKWConsumidosPorHora.multiply( new BigDecimal( cantidad_horas ));
    }

    @Override
    public DispositivoEstandar getObj() {
        return this;
    }

    /*
    Este getter esta asi para que sea igual para todos los dispositivos
     */
    public BigDecimal consumoActual() {
        return estimadoKWConsumidosPorHora;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
