package modelos.usuarios;

import com.google.gson.annotations.Expose;
import json.BeanToJson;
import modelos.dispositivos.Categoria;
import modelos.dispositivos.DispositivoEstandar;
import modelos.dispositivos.DispositivoInteligente;
import modelos.reglas.actuadores.Actuador;
import modelos.reglas.sensores.Sensor;

import java.util.ArrayList;
import java.util.List;

public class Domicilio extends BeanToJson<Domicilio> {

    @Expose
    private String direccion;
    @Expose
    private Boolean principal;
    @Expose
    private Categoria categoria;
    @Expose
    private final List<DispositivoInteligente> dispositivosInteligentes;
    @Expose
    private final List<DispositivoEstandar> dispositivosEstandar;
    @Expose
    private final String fechaAltaEnSistema;

    private final List<Actuador> actuadores;

    private final List<Sensor> sensores;
    /*
    Como el constructor pide todos los atributos, no habra nulls.
     */
    public Domicilio(String direccion, Boolean principal, Categoria categoria , String fecha) {
        this.direccion = direccion;
        this.principal = principal;
        this.categoria = categoria;
        this.fechaAltaEnSistema = fecha;
        this.dispositivosInteligentes = new ArrayList<DispositivoInteligente>();
        this.dispositivosEstandar = new ArrayList<DispositivoEstandar>();
        this.sensores = new ArrayList<Sensor>();
        this.actuadores = new ArrayList<Actuador>();
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

    // por ahora solo crear los constructores no usar getters y setters
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

}
