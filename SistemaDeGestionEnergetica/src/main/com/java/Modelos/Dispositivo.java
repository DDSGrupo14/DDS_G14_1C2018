package Modelos;


import Json.BeanToJson;

public class Dispositivo extends BeanToJson<Dispositivo> {

    private String nombre;
    private Double consumoPorHora;
    private Boolean encendido;
    private Integer tiempoEncendidoDelDia;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getConsumoPorHora() {
        return consumoPorHora;
    }

    public void setConsumoPorHora(Double consumoPorHora) {
        this.consumoPorHora = consumoPorHora;
    }

    public Boolean getEncendido() {
        return encendido;
    }

    public void setEncendido(Boolean encendido) {
        this.encendido = encendido;
    }

    public Integer getTiempoEncendidoDelDia() {
        return tiempoEncendidoDelDia;
    }

    public void setTiempoEncendidoDelDia(Integer tiempoEncendidoDelDia) {
        this.tiempoEncendidoDelDia = tiempoEncendidoDelDia;
    }

    @Override
    public Dispositivo getObj() {
        return this;
    }
}
