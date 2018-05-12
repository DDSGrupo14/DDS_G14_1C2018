package modelos;

import com.google.gson.annotations.Expose;
import json.BeanToJson;
import java.util.List;

public class Usuario extends BeanToJson<Usuario> {

    @Expose
    private String nombre;
    @Expose
    private String apellido;
    @Expose
    private String documento;
    @Expose
    private String telefono;
    @Expose
    private String fechaDeAltaDelServicio;
    @Expose
    private String fechaDeAltaEnSistema;
    @Expose
    private Integer puntaje;
    @Expose
    private String loginUsuario;
    @Expose
    private String clave;
    @Expose
    private List<Domicilio> domicilios;

    public Usuario(String nombre, String apellido, String documento, String telefono, String fechaDeAltaDelServicio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.telefono = telefono;
        this.fechaDeAltaDelServicio = fechaDeAltaDelServicio;
    }

    public List<Domicilio> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }

    @Override
    public Usuario getObj() {
        return this;
    }
}
