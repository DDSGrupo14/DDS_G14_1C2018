package modelos.enre;

import com.google.gson.annotations.Expose;
import json.BeanToJson;
import modelos.usuarios.Domicilio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transformador")
public class Transformador extends BeanToJson<Transformador> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transf_id", unique = true)
    private int transf_id;
    @OneToMany(
            mappedBy = "transformador",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Domicilio> domicilios;
    @ManyToOne
    @JoinColumn(name = "zona_id", nullable = false)
    private Zona zona;
    @Expose
    @Transient
    private List<String> direcciones;
    @Expose
    @Column
    @org.hibernate.annotations.Type(type = "yes_no")
    private Boolean estaActivo;
    @Expose
    @Column
    private double latitud;
    @Expose
    @Column
    private double longitud;

    public Transformador(Boolean estaActivo, double latitud, double longitud, List<String> direcciones) {
        this.estaActivo = estaActivo;
        this.latitud = latitud;
        this.longitud = longitud;
        this.direcciones = direcciones;
        this.domicilios = new ArrayList<>();
    }

    public Transformador() {
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public int getTransf_id() {
        return transf_id;
    }

    public void setTransf_id(int transf_id) {
        this.transf_id = transf_id;
    }

    public List<Domicilio> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }

    public Boolean getEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(Boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setDirecciones(List<String> direcciones) {
        this.direcciones = direcciones;
    }

    public List<String> getDirecciones() {
        return direcciones;
    }

    public Double obtenerConsumoActual(){

        return 1.;
    }

    @Override
    public Transformador getObj() {
        return this;
    }
}
