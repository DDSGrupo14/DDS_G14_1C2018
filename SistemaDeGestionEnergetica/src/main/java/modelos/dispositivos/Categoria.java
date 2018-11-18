package modelos.dispositivos;

import com.google.gson.annotations.Expose;
import json.BeanToJson;
import modelos.usuarios.Domicilio;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "categoria")
public class Categoria extends BeanToJson<Categoria> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id", unique = true)
    private int cat_id;

    @Expose
    @Column
    private String nombreCategoria;

    @Expose
    @Column(nullable = false)
    private BigDecimal cargoFijoPorMes;

    @Expose
    @Column(nullable = false)
    private BigDecimal cargoVariablePorHora;

    @OneToOne(
            mappedBy = "categoria",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Domicilio domicilio;

    /*
    @Transient
    private List<Double> cargosFijos = Arrays.asList( 18.76, 35.32, 60.71, 71.74, 110.38, 220.75, 443.59, 545.96, 887.19 );
    @Transient
    private List<Double> cargosVariables = Arrays.asList( 0.644, 0.644, 0.681, 0.738, 0.794, 0.832, 0.851, 0.851, 0.851 );
    */
    public Categoria(){}

    public Categoria(String nombreCategoria, BigDecimal cargoFijoPorMes, BigDecimal cargoVariablePorHora){
        this.nombreCategoria = nombreCategoria;
        this.cargoFijoPorMes = cargoFijoPorMes;
        this.cargoVariablePorHora = cargoVariablePorHora;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int id) {
        this.cat_id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public BigDecimal getCargoFijoPorMes() {
        return cargoFijoPorMes;
    }

    public void setCargoFijoPorMes(BigDecimal cargoFijo) {
        this.cargoFijoPorMes = cargoFijo;
    }

    public BigDecimal getCargoVariablePorHora() {
        return cargoVariablePorHora;
    }

    public void setCargoVariablePorHora(BigDecimal cargoVariable) {
        this.cargoVariablePorHora = cargoVariable;
    }

    @Override
    public Categoria getObj() {
        return this;
    }
}
