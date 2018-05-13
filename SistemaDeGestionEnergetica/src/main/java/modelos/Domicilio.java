package modelos;

import com.google.gson.annotations.Expose;
import json.BeanToJson;

import java.util.List;


public class Domicilio extends BeanToJson<Domicilio> {

    @Expose
    private String direccion;
    @Expose
    private Boolean principal;
    @Expose
    private Categoria categoria;
    @Expose
    private List<Dispositivo> dispositivos;

    /*
    Como el constructor pide todos los atributos, no habra nulls.
     */
    public Domicilio(String direccion, Boolean principal, Categoria categoria, List<Dispositivo> dispositivos) {
        this.direccion = direccion;
        this.principal = principal;
        this.categoria = categoria;
        this.dispositivos = dispositivos;
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
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

        return (int) dispositivos.stream().filter(Dispositivo::getEncendido).count();
    }
    public int cantidadDispositivosApagados(){

        return (int) dispositivos.stream().filter( disp -> !disp.getEncendido()).count();
    }
    public int cantidadTotalDispositivos(){

        return dispositivos.size();
    }
    public Boolean hayAlgunDispositivoEncendido(){

        return dispositivos.stream().anyMatch( Dispositivo::getEncendido);
    }
}
