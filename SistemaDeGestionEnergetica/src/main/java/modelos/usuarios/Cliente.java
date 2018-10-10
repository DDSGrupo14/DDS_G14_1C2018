package modelos.usuarios;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Cliente extends Usuario{

    @Expose
    @Column
    private Integer puntaje;
    @Expose
    @Transient
    private List<Domicilio> domicilios;

    public Cliente(String nombre, String apellido, String documento, String telefono, String loginUsuario, String password) {
        super( nombre, apellido, documento, telefono, loginUsuario, password );
        this.puntaje = 0;
        this.domicilios = new ArrayList<Domicilio>();
    }

    public Cliente() {
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

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public Cliente getObj() {
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

    public void aumentarPuntajePorDispositivoEstandar(){ puntaje =+ 15; }

}
