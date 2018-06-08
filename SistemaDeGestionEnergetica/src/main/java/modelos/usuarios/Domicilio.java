package modelos.usuarios;

import com.google.gson.annotations.Expose;
import json.BeanToJson;
import modelos.dispositivos.Categoria;
import modelos.dispositivos.Dispositivo;
import modelos.dispositivos.DispositivoEstandar;
import modelos.dispositivos.DispositivoInteligente;
import modelos.reglas.actuadores.Actuador;
import modelos.reglas.sensores.Sensor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Domicilio extends BeanToJson<Domicilio> {

    @Expose
    private String direccion;
    @Expose
    private Boolean principal;
    @Expose
    private Categoria categoria;
    @Expose
    private List<DispositivoInteligente> dispositivosInteligentes;
    @Expose
    private List<DispositivoEstandar> dispositivosEstandar;
    @Expose
    private String fechaAltaEnSistema;

    private List<Actuador> actuadores;

    private List<Sensor> sensores;
    /*
    Como el constructor pide todos los atributos, no habra nulls.
     */
    public Domicilio(String direccion, Boolean principal, Categoria categoria ) {
        this.direccion = direccion;
        this.principal = principal;
        this.categoria = categoria;
        this.fechaAltaEnSistema = LocalDateTime.now().toString();
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

        List< DispositivoInteligente > dispositivoInteligentes = dispositivosInteligentes.stream()
                .filter( d -> d instanceof DispositivoInteligente).map( d -> ( DispositivoInteligente) d)
                .collect(Collectors.toList());

        return (int) dispositivoInteligentes.stream().filter(DispositivoInteligente::estasEncendido).count();
    }
    public int cantidadDispositivosApagados(){

        List< DispositivoInteligente > dispositivoInteligentes = dispositivosInteligentes.stream()
                .filter( d -> d instanceof DispositivoInteligente).map( d -> ( DispositivoInteligente) d)
                .collect(Collectors.toList());

        return (int) dispositivoInteligentes.stream().filter( disp -> disp.estasApagado()).count();
    }
    public int cantidadTotalDispositivos(){

        return dispositivosInteligentes.size() + dispositivosEstandar.size();
    }
    public Boolean hayAlgunDispositivoEncendido(){

        return dispositivosInteligentes.stream().anyMatch( DispositivoInteligente::estasEncendido);
    }

    public void registrarDispositivoEstandar(DispositivoInteligente dispositivoEstandarAdaptado ){

        dispositivosEstandar.removeIf( dispositivo -> dispositivo.nombreDispositivo()
                .equals( dispositivoEstandarAdaptado.nombreDispositivo() ) );

        dispositivosInteligentes.add( dispositivoEstandarAdaptado );

    }

    public boolean seEncuentraRegistradoDispositivoEstandar( DispositivoInteligente dispositivoInteligenteAdaptado ){

        return dispositivosInteligentes.contains( dispositivoInteligenteAdaptado );

    }

    public Double cuantoGasto(Double periodo){
        List <Double> sumaDI = Map(this.dispositivosInteligentes, consumidoEnUltimasHoras(periodo));
        List <Double> sumaDE = Map(this.dispositivosEstandar, consumidoEnUltimasHoras(periodo));
        Double gastoDelPeriodo = sumaDI.sum() + sumaDE.sum();
        return sum(this.categoria.obtenerCargoFijo()) + sum(this.categoria.obtenerCargoVariable())*gastoDelPeriodo;
    }
}
