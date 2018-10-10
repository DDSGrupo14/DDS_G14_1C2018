package modelos.dispositivos;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @Column( name = "cat_id",unique = true)
    private int cat_id;

    @Column(nullable = false)
    private BigDecimal cargoFijo;

    @Column(nullable = false)
    private BigDecimal cargoVariable;

    /*
    @Transient
    private List<Double> cargosFijos = Arrays.asList( 18.76, 35.32, 60.71, 71.74, 110.38, 220.75, 443.59, 545.96, 887.19 );
    @Transient
    private List<Double> cargosVariables = Arrays.asList( 0.644, 0.644, 0.681, 0.738, 0.794, 0.832, 0.851, 0.851, 0.851 );
    */
    public Categoria(){}

    public Categoria(int cat_id, BigDecimal cargoFijo, BigDecimal cargoVariable){
        this.cat_id = cat_id;
        this.cargoFijo = cargoFijo;
        this.cargoVariable = cargoVariable;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int id) {
        this.cat_id = id;
    }

    public BigDecimal getCargoFijo() {
        return cargoFijo;
    }

    public void setCargoFijo(BigDecimal cargoFijo) {
        this.cargoFijo = cargoFijo;
    }

    public BigDecimal getCargoVariable() {
        return cargoVariable;
    }

    public void setCargoVariable(BigDecimal cargoVariable) {
        this.cargoVariable = cargoVariable;
    }

}
