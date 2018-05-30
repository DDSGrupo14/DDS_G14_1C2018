package modelos.usuarios;

import json.BeanToJson;

public abstract class Usuario extends BeanToJson<Usuario> {

    private String nombre;
    private String apellido;
    private String documento;
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
