package modelos.usuarios;

import com.google.gson.annotations.Expose;
import json.BeanToJson;

public abstract class Usuario extends BeanToJson<Usuario>{

    @Expose
    private String nombre;
    @Expose
    private String apellido;
    @Expose
    private String documento;
    @Expose
    private String telefono;
    private String loginUsuario;
    private String clave;

    public Usuario(String nombre, String apellido, String documento, String telefono ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.telefono = telefono;
    }

}
