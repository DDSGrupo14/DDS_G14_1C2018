package modelos.usuarios;

import com.google.gson.annotations.Expose;
import json.BeanToJson;

import javax.persistence.*;

@MappedSuperclass
public abstract class Usuario extends BeanToJson<Usuario>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id", unique = true)
    private int usuario_id;
    @Expose
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Expose
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Expose
    @Column(name = "documento", nullable = false)
    private String documento;
    @Expose
    @Column(name = "telefono", nullable = false)
    private String telefono;
    @Expose
    @Column(name = "login_usuario", unique = true, nullable = false)
    private String loginUsuario;
    @Expose
    @Column(name = "password", nullable = false)
    private String password;

    public Usuario(String nombre, String apellido, String documento, String telefono, String loginUsuario, String password ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.telefono = telefono;
        this.loginUsuario = loginUsuario;
        this.password = password;
    }

    public Usuario(){}

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int id) {
        this.usuario_id = id;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
