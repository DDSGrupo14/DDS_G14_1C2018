package modelos.dispositivos;

import java.util.Date;

public class LogEntry {

    private Date fecha;

    private String nombreDispositivo;

    private String estadoDispositivo;

    public LogEntry( Date fecha, String nombreDispositivo, String estadoDispositivo ) {

        this.fecha = fecha;
        this.nombreDispositivo = nombreDispositivo;
        this.estadoDispositivo = estadoDispositivo;

    }

    public Date getFecha() { return fecha; }

    public String getNombreDispositivo() {
        return nombreDispositivo;
    }

    public String getEstadoDispositivo() {
        return estadoDispositivo;
    }
}
