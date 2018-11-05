package modelos.reglas.sensores;

public enum Magnitud {

    TEMPERATURA(true, 0, false),
    SONIDO(true, 0, false),
    PRESION(true, 0, false),
    LUZ(false, 0, false),
    MOVIMIENTO(false, 0, false);

    private Boolean esCalculable;
    private int cantidad;
    private Boolean ocurrioEvento;

    Magnitud(Boolean calculable, int cantidad, Boolean ocurrioEvento){
        this.esCalculable = calculable;
        this.cantidad = cantidad;
        this.ocurrioEvento = ocurrioEvento;
    }

    public Boolean getEsCalculable() {
        return esCalculable;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getOcurrioEvento() {
        return ocurrioEvento;
    }

    public void setOcurrioEvento(Boolean ocurrioEvento) {
        this.ocurrioEvento = ocurrioEvento;
    }
}
