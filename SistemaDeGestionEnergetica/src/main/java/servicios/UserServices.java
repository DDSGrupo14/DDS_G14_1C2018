package servicios;

import modelos.Dispositivo;
import modelos.Domicilio;
import modelos.Usuario;

public class UserServices {

    public Long cantidadTotalDeDispositivos(Usuario usuario ){

        return usuario.getDomicilios().stream().filter( dom -> dom.getDispositivos() != null)
                .flatMap( dom -> dom.getDispositivos().stream()).count();
    }

    public Long cantidadTotalDeDispositivosEncendidos(Usuario usuario ){

        return usuario.getDomicilios().stream().filter( dom -> dom.getDispositivos() != null)
                .flatMap( dom -> dom.getDispositivos().stream())
                .filter( disp -> disp.getEncendido()).count();
    }

    public Long cantidadTotalDeDispositivosApagados(Usuario usuario ){

        return usuario.getDomicilios().stream().filter( dom -> dom.getDispositivos() != null)
                .flatMap( dom -> dom.getDispositivos().stream())
                .filter( disp -> !disp.getEncendido()).count();
    }

    public Boolean hayAlgunDispositivoEncendidoEnDomicilio(Domicilio domicilio){

        return domicilio.getDispositivos().stream().anyMatch( Dispositivo::getEncendido);
    }

    public Boolean hayAlgunDispositivoEncendidoEnCualquierDomicilio( Usuario usuario){

        return usuario.getDomicilios().stream().anyMatch( dom -> hayAlgunDispositivoEncendidoEnDomicilio(dom));
    }

    public void encenderDispositivo(Dispositivo dispositivo){
        dispositivo.setEncendido( true );
    }

    public void apagarDispositivo(Dispositivo dispositivo){
        dispositivo.setEncendido( false );
    }


}
