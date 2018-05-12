package Modelos;

import Json.BeanToJson;
import com.google.gson.annotations.Expose;

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
    private Integer telefono;
    @Expose
    private Date fechaDeAltaDelServicio;

    private Date fechaDeAltaEnSistema;

    private Integer puntaje;

    private Integer idSistema;

    private String loginUsuario;

    private String contrasenia;

    private List<Domicilio> listaDomicilios;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Date getFechaDeAltaDelServicio() {
        return fechaDeAltaDelServicio;
    }

    public void setFechaDeAltaDelServicio(Date fechaDeAltaDelServicio) {
        this.fechaDeAltaDelServicio = fechaDeAltaDelServicio;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public List<Domicilio> getListaDomicilios() {
        return listaDomicilios;
    }

    public void setListaDomicilios(List<Domicilio> listaDomicilios) {
        this.listaDomicilios = listaDomicilios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaDeAltaEnSistema() {
        return fechaDeAltaEnSistema;
    }

    public void setFechaDeAltaEnSistema(Date fechaDeAltaEnSistema) {
        this.fechaDeAltaEnSistema = fechaDeAltaEnSistema;
    }

    public Integer getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(Integer idSistema) {
        this.idSistema = idSistema;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public Usuario getObj() {
        return this;
    }
}
