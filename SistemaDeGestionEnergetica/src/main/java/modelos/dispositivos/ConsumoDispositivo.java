package modelos.dispositivos;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "consumoDispositivo")
public class ConsumoDispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cons_id", unique = true)
    private int cons_id;

    @Column
    private Date fecha;

    @Column
    private int disp_id;

    @Column
    private String estadoDispositivo;

    public ConsumoDispositivo(Date fecha, int disp_id, String estadoDispositivo ) {

        this.fecha = fecha;
        this.disp_id = disp_id;
        this.estadoDispositivo = estadoDispositivo;

    }

    public ConsumoDispositivo(){}

    public int getCons_id() {
        return cons_id;
    }

    public void setCons_id(int cons_id) {
        this.cons_id = cons_id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDisp_id() {
        return disp_id;
    }

    public void setDisp_id(int disp_id) {
        this.disp_id = disp_id;
    }

    public String getEstadoDispositivo() {
        return estadoDispositivo;
    }

    public void setEstadoDispositivo(String estadoDispositivo) {
        this.estadoDispositivo = estadoDispositivo;
    }
}
