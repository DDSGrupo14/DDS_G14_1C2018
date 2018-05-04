package main.java.Modelos;

import java.util.List;

public class Domicilio {

    private String direccion;
    private Boolean domicilioPrincipal;
 //   private Categoria categoria;
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
/*
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
*/
    public List<Dispositivo> getListaDispositivos() {
        return listaDispositivos;
    }

    public void setListaDispositivos(List<Dispositivo> listaDispositivos) {
        this.listaDispositivos = listaDispositivos;
    }
}
