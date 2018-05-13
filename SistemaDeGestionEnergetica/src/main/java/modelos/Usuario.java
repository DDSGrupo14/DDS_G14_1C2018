package modelos;

import com.google.gson.annotations.Expose;
import json.BeanToJson;
import java.util.List;
import java.util.Objects;

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

    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }

    public List<Domicilio> getDomicilios() {
        return domicilios;
    }

    @Override
    public Usuario getObj() {
        return this;
    }

    public int cantidadTotalDeDispositivosEncendidos(){

        return domicilios.stream().map(Domicilio::cantidadDispositivosEncendidos).reduce(0,Integer::sum);
    }
    public int cantidadTotalDeDispositivosApagados(){

        return domicilios.stream().map(Domicilio::cantidadDispositivosApagados).reduce(0,Integer::sum);
    }
    public int cantidadTotalDeDispositivos(){

        return domicilios.stream().map(Domicilio::cantidadTotalDispositivos).reduce(0,Integer::sum);
    }

    public Boolean hayAlgunDispositivoEncendidoEnElDomicilio( String direccion){

        Domicilio domicilio =  domicilios.stream().filter( dom -> dom.getDireccion().equalsIgnoreCase(direccion))
                .findAny().orElse(null);

        return Objects.isNull( domicilio )? false: domicilio.hayAlgunDispositivoEncendido();
    }

    public Boolean hayAlgunDispositivoEncendidoEnAlgunDomicilio(){

        return domicilios.stream().anyMatch( Domicilio::hayAlgunDispositivoEncendido );
    }
}
