package modelos.mongo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity("reportes")
public class Reporte {

    @Id
    private ObjectId id;

    private String nombreClase;

    private int idObjeto;

    @Indexed
    private LocalDate periodo_inicio;
    @Indexed
    private LocalDate periodo_fin;

    private BigDecimal consumoTotalPeriodo;

    private BigDecimal consumoPromedioPeriodo;

    public Reporte() {
    }

    public Reporte(String nombreClase, int idObjeto, LocalDate periodo_inicio,
                   LocalDate periodo_fin, BigDecimal consumoTotalPeriodo, BigDecimal consumoPromedioPeriodo) {
        this.nombreClase = nombreClase;
        this.idObjeto = idObjeto;
        this.periodo_inicio = periodo_inicio;
        this.periodo_fin = periodo_fin;
        this.consumoTotalPeriodo = consumoTotalPeriodo;
        this.consumoPromedioPeriodo = consumoPromedioPeriodo;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public LocalDate getPeriodo_inicio() {
        return periodo_inicio;
    }

    public void setPeriodo_inicio(LocalDate periodo_inicio) {
        this.periodo_inicio = periodo_inicio;
    }

    public LocalDate getPeriodo_fin() {
        return periodo_fin;
    }

    public void setPeriodo_fin(LocalDate periodo_fin) {
        this.periodo_fin = periodo_fin;
    }

    public BigDecimal getConsumoTotalPeriodo() {
        return consumoTotalPeriodo;
    }

    public void setConsumoTotalPeriodo(BigDecimal consumoTotalPeriodo) {
        this.consumoTotalPeriodo = consumoTotalPeriodo;
    }

    public BigDecimal getConsumoPromedioPeriodo() {
        return consumoPromedioPeriodo;
    }

    public void setConsumoPromedioPeriodo(BigDecimal consumoPromedioPeriodo) {
        this.consumoPromedioPeriodo = consumoPromedioPeriodo;
    }
}
