package modelos.reglas.actuadores;

import modelos.dispositivos.DispositivoInteligente;
import modelos.reglas.reglas.Regla;
import modelos.usuarios.Domicilio;

import javax.persistence.*;

@Entity
@Table(name = "actuador")
public class Actuador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "act_id", unique = true)
    private int act_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dom_id")
    private Domicilio domicilio;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dint_id")
    private DispositivoInteligente dispositivoInteligente;


    @OneToOne(
            mappedBy = "actuador",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Regla regla;


    public Actuador( DispositivoInteligente dispositivoInteligente ){

        this.dispositivoInteligente = dispositivoInteligente;
    }

    public Actuador(){}

    public int getAct_id() {
        return act_id;
    }

    public void setAct_id(int act_id) {
        this.act_id = act_id;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public DispositivoInteligente getDispositivoInteligente() {
        return dispositivoInteligente;
    }

    public void setDispositivoInteligente(DispositivoInteligente dispositivoInteligente) {
        this.dispositivoInteligente = dispositivoInteligente;
    }

    public void apagar(){ dispositivoInteligente.apagarDispositivo(); }

    public void encender() { dispositivoInteligente.encenderDispositivo(); }

    public void ahorroEnergia() { dispositivoInteligente.pasarAhorroEnergia(); }

}
