package modelos.dispositivos;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
public class TipoDispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tdisp_id", unique = true)
    private int tdisp_id;

    @Expose
    @Column
    private String equipoConcreto;
    @Expose
    @Column
    private int usoMensualMinimo;
    @Expose
    @Column
    private int usoMensualMaximo;
    @Expose
    @Column
    private BigDecimal consumoEstimadoKWh;
    @org.hibernate.annotations.Type(type = "yes_no")
    private boolean esInteligente;
    @org.hibernate.annotations.Type(type = "yes_no")
    private boolean esBajoConsumo;

    public TipoDispositivo(String equipoConcreto, int usoMensualMinimo, int usoMensualMaximo, BigDecimal consumoEstimadoKWh) {
        this.equipoConcreto = equipoConcreto;
        this.usoMensualMinimo = usoMensualMinimo;
        this.usoMensualMaximo = usoMensualMaximo;
        this.consumoEstimadoKWh = consumoEstimadoKWh;
    }

    public TipoDispositivo(){}

    public int getTdisp_id() {
        return tdisp_id;
    }

    public void setTdisp_id(int tdisp_id) {
        this.tdisp_id = tdisp_id;
    }

    public void setEquipoConcreto(String equipoConcreto) {
        this.equipoConcreto = equipoConcreto;
    }

    public void setUsoMensualMinimo(int usoMensualMinimo) {
        this.usoMensualMinimo = usoMensualMinimo;
    }

    public void setUsoMensualMaximo(int usoMensualMaximo) {
        this.usoMensualMaximo = usoMensualMaximo;
    }

    public void setConsumoEstimadoKWh(BigDecimal consumoEstimadoKWh) {
        this.consumoEstimadoKWh = consumoEstimadoKWh;
    }

    public boolean isEsInteligente() {
        return esInteligente;
    }

    public void setEsInteligente(boolean esInteligente) {
        this.esInteligente = esInteligente;
    }

    public boolean isEsBajoConsumo() {
        return esBajoConsumo;
    }

    public void setEsBajoConsumo(boolean esBajoConsumo) {
        this.esBajoConsumo = esBajoConsumo;
    }

    public String getEquipoConcreto() {
        return equipoConcreto;
    }

    public int getUsoMensualMinimo() {
        return usoMensualMinimo;
    }

    public int getUsoMensualMaximo() {
        return usoMensualMaximo;
    }

    public BigDecimal getConsumoEstimadoKWh() {
        return consumoEstimadoKWh;
    }
}
