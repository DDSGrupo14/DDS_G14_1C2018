package modelos.usuarios;

import modelos.reglas.actuadores.Actuador;
import modelos.reglas.sensores.Sensor;

import java.util.List;
import java.util.Objects;

public class Cliente extends Usuario{

    private String fechaDeAltaDelServicio;

    private Integer puntaje;

    private List<Domicilio> domicilios;

    public Cliente(String nombre, String apellido, String documento, String telefono, String fechaDeAltaDelServicio) {
        super( nombre, apellido, documento, telefono );
        this.fechaDeAltaDelServicio = fechaDeAltaDelServicio;
    }

    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }

    public List<Domicilio> getDomicilios() {
        return domicilios;
    }

    public Integer getPuntaje() {
        return puntaje;
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

    public void aumentarPuntajePorDispositivoEstandar(){

        puntaje =+ 15;
    }

}
