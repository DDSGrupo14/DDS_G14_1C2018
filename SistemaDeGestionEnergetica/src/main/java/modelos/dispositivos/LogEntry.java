package modelos.dispositivos;

import java.util.Date;

public class LogEntry {

    private Date fecha;

    private String nombreDispositivo;

    private String estadoDispositivo;

    public LogEntry( String entradaDeLog ) {

        /*
        Parsear entrada de log y llenar atributos
         */

    }

    public Date getFecha() {
        return fecha;
    }

    public String getNombreDispositivo() {
        return nombreDispositivo;
    }

    public String getEstadoDispositivo() {
        return estadoDispositivo;
    }
}
