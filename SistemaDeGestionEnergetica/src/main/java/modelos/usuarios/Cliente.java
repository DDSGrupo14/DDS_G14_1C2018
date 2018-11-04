package modelos.usuarios;

import com.google.gson.annotations.Expose;
import modelos.dispositivos.Categoria;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cliente")
public class Cliente extends Usuario{

    @Expose
    @Column
    private Integer puntaje;
    @Expose
    @OneToMany(
            mappedBy = "cliente",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Domicilio> domicilios;

    public Cliente(String nombre, String apellido, String documento, String telefono, String loginUsuario, String password) {
        super( nombre, apellido, documento, telefono, loginUsuario, password );
        this.puntaje = 0;
        this.domicilios = new ArrayList<Domicilio>();
    }

    public Cliente() {
    }

    public Cliente agregarDomicilio(Domicilio domicilio , Categoria categoria){

        domicilios.add( domicilio );
        domicilio.setCliente(this);
        domicilio.setCategoria(categoria);
        categoria.setDomicilio(domicilio);
        return this;
    }

    public void quitarDomicilio( Domicilio domicilio ){

        domicilios.remove( domicilio );
        domicilio.setCliente(null);

    }

    public List<Domicilio> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
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
