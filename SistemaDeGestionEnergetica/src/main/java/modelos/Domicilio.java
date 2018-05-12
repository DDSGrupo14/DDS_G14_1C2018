package modelos;

import json.BeanToJson;

import java.util.List;

public class Domicilio extends BeanToJson<Domicilio> {

    private String direccion;
    //para no ser redundantes con que se llame el atributo principal es suficiente
    private Boolean domicilioPrincipal;
    private Categoria categoria;
    private String direccionDomicilio;//ya existe direccion domicilio

    private List< Dispositivo > listaDispositivos;//con que se llame dispositivos es mas representativo

    // por ahora solo crear los constructores no usar getters y setters
    @Override
    public Domicilio getObj() {
        return this;
    }
}
