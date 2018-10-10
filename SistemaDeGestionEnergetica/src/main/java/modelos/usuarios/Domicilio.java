package modelos.usuarios;

import com.google.gson.annotations.Expose;
import json.BeanToJson;
import modelos.dispositivos.DispositivoEstandar;
import modelos.dispositivos.DispositivoInteligente;
import modelos.reglas.actuadores.Actuador;
import modelos.reglas.sensores.Sensor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "domicilio")
public class Domicilio extends BeanToJson<Domicilio> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "dom_id",unique = true)
    private int dom_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Cliente cliente;

    @Expose
    @Column(nullable = false)
    private String direccion;
    @Expose
    @org.hibernate.annotations.Type(type = "yes_no")
    private Boolean principal;
    @Expose
    @Column
    private int categoria;
    @Expose
    @Transient
    private List<DispositivoInteligente> dispositivosInteligentes;
    @Expose
    @Transient
    private List<DispositivoEstandar> dispositivosEstandar;
    @Expose
    @Column
    private String fechaAltaEnSistema;
    @Expose
    @Transient
    private List<Actuador> actuadores;
    @Expose
    @Transient
    private List<Sensor> sensores;
    /*
    Como el constructor pide todos los atributos, no habra nulls.
     */
    public Domicilio(String direccion, Boolean principal, int categoria , String fecha) {
        this.direccion = direccion;
        this.principal = principal;
        this.categoria = categoria;
        this.fechaAltaEnSistema = fecha;
        this.dispositivosInteligentes = new ArrayList<DispositivoInteligente>();
        this.dispositivosEstandar = new ArrayList<DispositivoEstandar>();
        this.sensores = new ArrayList<Sensor>();
        this.actuadores = new ArrayList<Actuador>();
    }

    public Domicilio(){}

    public int getDom_id() {
        return dom_id;
    }

    public void setDom_id(int id) {
        this.dom_id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public List<DispositivoInteligente> getDispositivosInteligentes() {
        return dispositivosInteligentes;
    }

    public List<DispositivoEstandar> getDispositivosEstandar() {
        return dispositivosEstandar;
    }

    public String getFechaAltaEnSistema() {
        return fechaAltaEnSistema;
    }

    public void setFechaAltaEnSistema(String fechaAltaEnSistema) {
        this.fechaAltaEnSistema = fechaAltaEnSistema;
    }

    public Domicilio agregarDispositivoInteligente(DispositivoInteligente dispositivo ){
        dispositivosInteligentes.add( dispositivo );
        return this;
    }

    public Domicilio agregarDispositivoEstandar(DispositivoEstandar dispositivo ){
        dispositivosEstandar.add( dispositivo );
        return this;
    }

    public List<Actuador> getActuadores() {
        return actuadores;
    }

    public Domicilio agregarActuador( Actuador actuador) {

        actuadores.add( actuador );

        return this;
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public Domicilio agregarSensor( Sensor sensor){
        sensores.add( sensor );
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    @Override
    public Domicilio getObj() {
        return this;
    }

    public int cantidadDispositivosEncendidos(){

        return (int) dispositivosInteligentes.stream().filter(DispositivoInteligente::estasEncendido).count();
    }
    public int cantidadDispositivosApagados(){

        return (int) dispositivosInteligentes.stream().filter( disp -> disp.estasApagado()).count();
    }
    public int cantidadTotalDispositivos(){

        return dispositivosInteligentes.size() + dispositivosEstandar.size();
    }
    public Boolean hayAlgunDispositivoEncendido(){

        return dispositivosInteligentes.stream().anyMatch( DispositivoInteligente::estasEncendido);
    }

    public void registrarDispositivoEstandar(DispositivoInteligente dispositivoEstandarAdaptado ){

        dispositivosEstandar.removeIf( dispositivo -> dispositivo.getNombre()
                .equals( dispositivoEstandarAdaptado.getNombre() ) );

        dispositivosInteligentes.add( dispositivoEstandarAdaptado );

    }

    public boolean seEncuentraRegistradoDispositivoEstandar( DispositivoInteligente dispositivoInteligenteAdaptado ){

        return dispositivosInteligentes.contains( dispositivoInteligenteAdaptado );

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Domicilio )) return false;
        return dom_id == (((Domicilio) o).dom_id);
    }
    @Override
    public int hashCode() {
        return 31;
    }
}
