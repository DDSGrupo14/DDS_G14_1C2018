package modelos.dispositivos.adaptadores;

import com.google.gson.annotations.Expose;
import json.BeanToJson;
import modelos.dispositivos.DispositivoEstandar;
import modelos.dispositivos.DispositivoInteligente;
import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "adaptador")
public class Adaptador extends BeanToJson<Adaptador> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adap_id", unique = true)
    private int adap_id;

    @Column
    private int cliente_id;

    @Expose
    @Column
    private BigDecimal consumoPorHora;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dint_id")
    private DispositivoInteligente dispositivoInteligente;

    @Expose
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dest_id")
    private DispositivoEstandar dispositivoEstandar;

    /*
    Uso este nombre para identificar cada adaptador, tiene que ser unico
     */
    @Expose
    @Column(nullable = false)
    private String nombreAdaptador;

    public Adaptador(BigDecimal consumoPorHora, String nombre) {

        this.consumoPorHora = consumoPorHora.setScale(2, RoundingMode.HALF_UP);
        this.nombreAdaptador = nombre;
    }

    public Adaptador(){}

    public int getAdap_id() {
        return adap_id;
    }

    public void setAdap_id(int adap_id) {
        this.adap_id = adap_id;
    }

    public void setConsumoPorHora(BigDecimal consumoPorHora) {
        this.consumoPorHora = consumoPorHora;
    }

    public void setNombreAdaptador(String nombreAdaptador) {
        this.nombreAdaptador = nombreAdaptador;
    }

    public BigDecimal getConsumoPorHora() {
        return consumoPorHora;
    }

    public String getNombreAdaptador() {
        return nombreAdaptador;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public DispositivoInteligente getDispositivoInteligente() {
        return dispositivoInteligente;
    }

    public void setDispositivoInteligente(DispositivoInteligente dispositivoInteligente) {
        this.dispositivoInteligente = dispositivoInteligente;
    }

    public DispositivoEstandar getDispositivoEstandar() {
        return dispositivoEstandar;
    }

    public void setDispositivoEstandar(DispositivoEstandar dispositivoEstandar) {
        this.dispositivoEstandar = dispositivoEstandar;
    }

    @Override
    public Adaptador getObj() {
        return null;
    }
}
