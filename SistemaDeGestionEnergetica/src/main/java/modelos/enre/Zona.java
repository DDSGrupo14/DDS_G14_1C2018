package modelos.enre;

import com.google.gson.annotations.Expose;
import json.BeanToJson;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zona")
public class Zona extends BeanToJson<Zona> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zona_id", unique = true)
    private int zona_id;
    @Expose
    @Column(unique = true)
    private String codigo;
    @Expose
    @Column
    private double latitud;
    @Expose
    @Column
    private double longitud;
    @Expose
    @Column
    private double radio;
    @Expose
    @OneToMany(
            mappedBy = "zona",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Transformador> transformadores;

    public Zona(String codigo, double latitud, double longitud,double radio, List<Transformador> transformadores) {
        this.codigo = codigo;
        this.latitud = latitud;
        this.radio = radio;
        this.longitud = longitud;
        this.transformadores= transformadores;
    }

    public Zona() {
    }

    public int getZona_id() {
        return zona_id;
    }

    public void setZona_id(int zona_id) {
        this.zona_id = zona_id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
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

    public List<Transformador> getTransformadores() {
        return transformadores;
    }

    public void setTransformadores(List<Transformador> transformadores) {
        this.transformadores = transformadores;
        transformadores.forEach(transformador -> transformador.setZona(this));
    }

    public void agregarTransformador(Transformador transformador){ transformadores.add(transformador); }

    public void calcularConsumoDeTransformadores(){
        transformadores.forEach(Transformador::obtenerConsumoActual);
    }

    public Double obtenerConsumoTotalActual(){

        return transformadores.stream().map( Transformador::obtenerConsumoActual).reduce(0.,Double::sum);
    }

    public void enviarConsumoEnre(){}

    @Override
    public Zona getObj() {
        return this;
    }
}
