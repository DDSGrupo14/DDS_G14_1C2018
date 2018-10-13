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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dint_id")
    private DispositivoInteligente dispositivoInteligente;

    @Column
    private String estadoDispositivo;

    public ConsumoDispositivo(Date fecha, DispositivoInteligente dispositivoInteligente, String estadoDispositivo ) {

        this.fecha = fecha;
        this.dispositivoInteligente = dispositivoInteligente;
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

    public DispositivoInteligente getDispositivoInteligente() {
        return dispositivoInteligente;
    }

    public void setDispositivoInteligente(DispositivoInteligente dispositivoInteligente) {
        this.dispositivoInteligente = dispositivoInteligente;
    }

    public String getEstadoDispositivo() {
        return estadoDispositivo;
    }

    public void setEstadoDispositivo(String estadoDispositivo) {
        this.estadoDispositivo = estadoDispositivo;
    }
}
