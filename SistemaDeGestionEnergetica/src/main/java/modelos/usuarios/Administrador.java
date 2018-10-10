package modelos.usuarios;

public class Administrador extends Usuario{

    private String fechaDeAltaEnSistema;

    public Administrador(String nombre, String apellido, String documento, String telefono, String fechaDeAltaEnSistema
    , String loginUsuario, String password) {
        super( nombre, apellido, documento, telefono , loginUsuario, password);
        this.fechaDeAltaEnSistema = fechaDeAltaEnSistema;
    }

    @Override
    public Usuario getObj() {
        return this;
    }
}
