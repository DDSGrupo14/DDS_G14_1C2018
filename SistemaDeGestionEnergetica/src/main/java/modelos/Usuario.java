package modelos;


import com.google.gson.annotations.Expose;
import json.BeanToJson;

import java.util.Date;
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
    private Date fechaDeAltaDelServicio;
    @Expose
    private Date fechaDeAltaEnSistema;
    @Expose
    private Integer puntaje;
    @Expose
    private String loginUsuario;
    @Expose
    private String contrasenia;//cambiarlo por clave
    @Expose
    private List<Domicilio> listaDomicilios;//cambiarlo por domicilios es mas representativo

    public Usuario(String nombre, String apellido, String documento, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.telefono = telefono;
    }

    @Override
    public Usuario getObj() {
        return this;
    }
}
