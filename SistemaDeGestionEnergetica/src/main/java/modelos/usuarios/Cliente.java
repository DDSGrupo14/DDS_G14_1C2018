package modelos.usuarios;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente extends Usuario{

    @Expose
    private Integer puntaje;
    @Expose
    private List<Domicilio> domicilios;

    public Cliente(String nombre, String apellido, String documento, String telefono) {
        super( nombre, apellido, documento, telefono );
        this.puntaje = 0;
        this.domicilios = new ArrayList<Domicilio>();
    }

    public Cliente agregarDomicilio( Domicilio domicilio ){

        domicilios.add( domicilio );
        return this;

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
