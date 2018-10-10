package modelos.usuarios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Administrador extends Usuario{

    @Column
    private String fechaDeAltaEnSistema;

    public Administrador(String nombre, String apellido, String documento, String telefono, String fechaDeAltaEnSistema
    , String loginUsuario, String password) {
        super( nombre, apellido, documento, telefono , loginUsuario, password);
        this.fechaDeAltaEnSistema = fechaDeAltaEnSistema;
    }

    public Administrador(){}

    public String getFechaDeAltaEnSistema() {
        return fechaDeAltaEnSistema;
    }

    public void setFechaDeAltaEnSistema(String fechaDeAltaEnSistema) {
        this.fechaDeAltaEnSistema = fechaDeAltaEnSistema;
    }

    @Override
    public Usuario getObj() {
        return this;
    }
}
