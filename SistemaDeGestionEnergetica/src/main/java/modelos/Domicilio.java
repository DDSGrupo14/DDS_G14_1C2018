package modelos;

import com.google.gson.annotations.Expose;
import json.BeanToJson;
import modelos.dispositivos.DispositivoInteligente;

import java.util.List;


public class Domicilio extends BeanToJson<Domicilio> {

    @Expose
    private String direccion;
    @Expose
    private Boolean principal;
    @Expose
    private Categoria categoria;
    @Expose
    private List<DispositivoInteligente> dispositivos;

    /*
    Como el constructor pide todos los atributos, no habra nulls.
     */
    public Domicilio(String direccion, Boolean principal, Categoria categoria, List<DispositivoInteligente> dispositivos) {
        this.direccion = direccion;
        this.principal = principal;
        this.categoria = categoria;
        this.dispositivos = dispositivos;
    }

    public List<DispositivoInteligente> getDispositivos() {
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

        return (int) dispositivos.stream().filter(DispositivoInteligente::getEncendido).count();
    }
    public int cantidadDispositivosApagados(){

        return (int) dispositivos.stream().filter( disp -> !disp.getEncendido()).count();
    }
    public int cantidadTotalDispositivos(){

        return dispositivos.size();
    }
    public Boolean hayAlgunDispositivoEncendido(){

        return dispositivos.stream().anyMatch( DispositivoInteligente::getEncendido);
    }
}
