package modelos.usuarios;

import com.google.gson.annotations.Expose;
import json.BeanToJson;
import modelos.dispositivos.Categoria;
import modelos.dispositivos.Dispositivo;
import modelos.dispositivos.DispositivoEstandar;
import modelos.dispositivos.DispositivoInteligente;
import modelos.reglas.actuadores.Actuador;
import modelos.reglas.sensores.Sensor;

import java.util.List;
import java.util.stream.Collectors;


public class Domicilio extends BeanToJson<Domicilio> {

    @Expose
    private String direccion;
    @Expose
    private Boolean principal;
    @Expose
    private Categoria categoria;
    @Expose
    private List<Dispositivo> dispositivos;

    private List< String > dispositivosEstandarRegistrados;

    private List<Actuador> actuadores;

    private List<Sensor> sensores;
    /*
    Como el constructor pide todos los atributos, no habra nulls.
     */
    public Domicilio(String direccion, Boolean principal, Categoria categoria ) {
        this.direccion = direccion;
        this.principal = principal;
        this.categoria = categoria;
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public Domicilio agregarDispositivo(Dispositivo dispositivo ){
        dispositivos.add( dispositivo );

        return this;
    }

    public List<Actuador> getActuadores() {
        return actuadores;
    }

    public void agregarActuador( Actuador actuador) {

        actuadores.add( actuador );
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public void agregarSensor( Sensor sensor){
        sensores.add( sensor );
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

        List< DispositivoInteligente > dispositivoInteligentes = dispositivos.stream()
                .filter( d -> d instanceof DispositivoInteligente).map( d -> ( DispositivoInteligente) d)
                .collect(Collectors.toList());

        return (int) dispositivoInteligentes.stream().filter(DispositivoInteligente::estasEncendido).count();
    }
    public int cantidadDispositivosApagados(){

        List< DispositivoInteligente > dispositivoInteligentes = dispositivos.stream()
                .filter( d -> d instanceof DispositivoInteligente).map( d -> ( DispositivoInteligente) d)
                .collect(Collectors.toList());

        return (int) dispositivoInteligentes.stream().filter( disp -> disp.estasApagado()).count();
    }
    public int cantidadTotalDispositivos(){

        return dispositivos.size();
    }
    public Boolean hayAlgunDispositivoEncendido(){

        List< DispositivoInteligente > dispositivoInteligentes = dispositivos.stream()
                .filter( d -> d instanceof DispositivoInteligente).map( d -> ( DispositivoInteligente) d)
                .collect(Collectors.toList());

        return dispositivoInteligentes.stream().anyMatch( DispositivoInteligente::estasEncendido);
    }

    public void registrarDispositivoEstandar(DispositivoInteligente dispositivoEstandarAdaptado ){

        dispositivos.removeIf( dispositivo -> dispositivo.nombreDispositivo()
                .equals( dispositivoEstandarAdaptado.nombreDispositivo() ) );

        dispositivos.add( dispositivoEstandarAdaptado );

        dispositivosEstandarRegistrados.add( dispositivoEstandarAdaptado.nombreDispositivo() );

    }

    public boolean seEncuentraRegistradoDispositivoEstandar( DispositivoInteligente dispositivoInteligenteAdaptado ){

        return dispositivosEstandarRegistrados.contains( dispositivoInteligenteAdaptado.nombreDispositivo() );

    }

}
