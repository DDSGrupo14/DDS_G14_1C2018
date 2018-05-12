package modelos;

import json.BeanToJson;

import java.util.List;

public class Domicilio extends BeanToJson<Domicilio> {

    private String direccion;
    private Boolean domicilioPrincipal;
    private Categoria categoria;
    private String direccionDomicilio;

    private List< Dispositivo > listaDispositivos;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getDomicilioPrincipal() {
        return domicilioPrincipal;
    }

    public void setDomicilioPrincipal(Boolean domicilioPrincipal) {
        this.domicilioPrincipal = domicilioPrincipal;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Dispositivo> getListaDispositivos() {
        return listaDispositivos;
    }

    public void setListaDispositivos(List<Dispositivo> listaDispositivos) {
        this.listaDispositivos = listaDispositivos;
    }

    public String getDireccionDomicilio() {
        return direccionDomicilio;
    }

    public void setDireccionDomicilio(String direccionDomicilio) {
        this.direccionDomicilio = direccionDomicilio;
    }

    @Override
    public Domicilio getObj() {
        return this;
    }
}
