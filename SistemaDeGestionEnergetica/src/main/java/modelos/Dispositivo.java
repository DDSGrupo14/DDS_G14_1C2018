package modelos;


import json.BeanToJson;

public class Dispositivo extends BeanToJson<Dispositivo> {

    private String nombre;
    private Double consumoPorHora;//cambiar a BigDecimal, usar setScale(2, y un rounding)
    private Boolean encendido;
    private Integer tiempoEncendidoDelDia;//esto es mejor sacarlo y pensarlo bien en la entrega siguiente

    @Override
    public Dispositivo getObj() {
        return this;
    }
}
